package com.walatech.phonebook.repository;

import com.walatech.phonebook.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact,Long> {

    Optional<Contact> findByPhone(String phone);
}
