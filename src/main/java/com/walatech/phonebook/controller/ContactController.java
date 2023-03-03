package com.walatech.phonebook.controller;

import com.walatech.phonebook.dto.ContactDto;
import com.walatech.phonebook.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/contacts")
public class ContactController {

    private ContactService contactService;

    @PostMapping
    public ResponseEntity<ContactDto> createContact(@Valid @RequestBody ContactDto contact){
        ContactDto savedMovie = contactService.createContact(contact);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable("id") Long contactId){
        ContactDto movie = contactService.getContactById(contactId);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ContactDto>> getAllContacts(){
        List<ContactDto> movieList = contactService.getAllContacts();
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ContactDto> updateContact(@PathVariable("id") Long contactId,
                                                @Valid @RequestBody ContactDto contact){
        contact.setId(contactId);
        ContactDto updatedMovie = contactService.updateContact(contact);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") Long contactId){
        contactService.deleteContact(contactId);
        return new ResponseEntity<>("Phone successfully deleted",HttpStatus.OK);
    }
}
