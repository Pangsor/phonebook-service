package com.walatech.phonebook.repository;

import com.walatech.phonebook.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
