package ch.zli.m223.ksh19a.md.CRM.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.ksh19a.md.CRM.controller.dto.CustomerDto;
import ch.zli.m223.ksh19a.md.CRM.controller.dto.CustomerInputDto;
import ch.zli.m223.ksh19a.md.CRM.controller.dto.NoteDto;
import ch.zli.m223.ksh19a.md.CRM.controller.dto.NoteInputDto;
import ch.zli.m223.ksh19a.md.CRM.exception.NotFoundException;
import ch.zli.m223.ksh19a.md.CRM.model.Gender;
import ch.zli.m223.ksh19a.md.CRM.model.Note;
import ch.zli.m223.ksh19a.md.CRM.model.NoteImpl;
import ch.zli.m223.ksh19a.md.CRM.repository.GenderRepository;
import ch.zli.m223.ksh19a.md.CRM.service.CustomerService;
import ch.zli.m223.ksh19a.md.CRM.service.UserService;
/**
 * Rest controller for the customer
 * @author mardpp1
 *
 */
@RestController
@RequestMapping("/api/v1")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GenderRepository genderRepository;
	

	@GetMapping("/customers")
	List<CustomerDto> getAllCustomers(){
		return customerService.getAllCustomers().stream()
				.map(customer -> new CustomerDto(customer))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/customers/{id}")
	CustomerDto getCustomer(@PathVariable("id") Long id) {
		return new CustomerDto(customerService.getCustomer(id));
	}
	
	@PostMapping("/customers")
	CustomerDto insertCustomer(@RequestBody CustomerInputDto customerData) {
		Optional<Gender> optGender = genderRepository.findGenderByGenderName(customerData.gender);
		Gender gender;
		
		if (optGender.isPresent()) {
			gender = optGender.get();
		}
		else {
			gender = genderRepository.insert(customerData.gender);
		}

		return new CustomerDto(customerService.insertCustomer(customerData.firstname, customerData.lastname, customerData.birthdate, gender));
	}
	
	
	@DeleteMapping("/customers/{id}")
	void deleteCustomer(@PathVariable("id") Long id) {
		customerService.deleteCustomer(id);
	}
	
	
	@GetMapping("/customers/{id}/notes")
	List<NoteDto> getNotesForCustomer(@PathVariable("id") Long id) {
		List<NoteDto> noteList = new ArrayList<>();
		for (var note : customerService.getCustomer(id).getNotes()) {
			noteList.add(new NoteDto(note));
		}
		return noteList;
	}
	
	
	@PostMapping("/customers/{id}/notes")
	NoteDto insertNote(@PathVariable("id") Long id, @RequestBody NoteInputDto noteData) {
		Note note = new NoteImpl(noteData.note, userService.getUser(noteData.appUserId), customerService.getCustomer(id));
		customerService.update(customerService.getCustomer(id).addNoteToList((NoteImpl)note));
		
		//return new NoteDto(note);			//gibt id = null, da id erst bei Datenbank Eintrag generiert wird
		return new NoteDto(customerService.getCustomer(id).getNotes().get(customerService.getCustomer(id).getNotes().size() - 1));
	}
	
	
	@GetMapping("/customers/{id}/notes/{noteId}")
	NoteDto getNotesForCustomer(@PathVariable("id") Long id, @PathVariable("noteId") Long noteId) {
		Optional<NoteDto> optNote = customerService.getCustomer(id).getNotes().stream()
			.filter(notes -> notes.getId() == noteId)
			.map(note -> new NoteDto(note))
			.findAny();
		
		return optNote.orElseThrow(() -> {
			throw new NotFoundException("Note not found");
		});
	}
	
	
	

	
}
