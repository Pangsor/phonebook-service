package com.walatech.phonebook.service.impl;

import com.walatech.phonebook.dto.ContactDto;
import com.walatech.phonebook.entity.Contact;
import com.walatech.phonebook.exception.DuplicateContactException;
import com.walatech.phonebook.exception.ResourceNotFoundException;
import com.walatech.phonebook.repository.ContactRepository;
import com.walatech.phonebook.service.ContactService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;
    private ModelMapper modelMapper;

    @Override
    public ContactDto createContact(ContactDto contactDto) {
        Optional<Contact> optionalContact = contactRepository.findByPhone(contactDto.getPhone());

        if(optionalContact.isPresent()){
            throw new DuplicateContactException("Phone Already Exists for Contact");
        }
        Contact contact = modelMapper.map(contactDto,Contact.class);
        Contact savedContact = contactRepository.save(contact);

        return modelMapper.map(savedContact,ContactDto.class);
    }

    @Override
    public ContactDto getContactById(Long contactId) {
        Contact movie = contactRepository.findById(contactId).orElseThrow(
                () -> new ResourceNotFoundException("Contact","id",contactId)
        );
        return modelMapper.map(movie,ContactDto.class);
    }

    @Override
    public List<ContactDto> getAllContacts() {
        List<Contact> movies = contactRepository.findAll();
        return movies.stream().map((movie) -> modelMapper.map(movie,ContactDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ContactDto updateContact(ContactDto contact) {
        Contact existingContact = contactRepository.findById(contact.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Contact","id",contact.getId())
        );
        existingContact.setName(contact.getName());
        existingContact.setPhone(contact.getPhone());
        Contact updatedMovie = contactRepository.save(existingContact);
        return modelMapper.map(updatedMovie,ContactDto.class);
    }

    @Override
    public void deleteContact(Long contactId) {
        contactRepository.findById(contactId).orElseThrow(
                () -> new ResourceNotFoundException("Contact","id",contactId)
        );
        contactRepository.deleteById(contactId);
    }

    @Override
    public List<ContactDto> getContactByName(String name) {
        List<Contact> contactList = contactRepository.findContactByName(name);
        return contactList.stream().map((movie) -> modelMapper.map(movie,ContactDto.class))
                .collect(Collectors.toList());
    }
}
