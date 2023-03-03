package com.walatech.phonebook.service;

import com.walatech.phonebook.dto.ContactDto;

import java.util.List;

public interface ContactService {

    ContactDto createContact(ContactDto contact);
    ContactDto getContactById(Long contactId);
    List<ContactDto> getAllContacts();
    ContactDto updateContact(ContactDto contact);
    void deleteContact(Long contactId);
}
