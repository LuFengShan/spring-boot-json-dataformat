package com.gx.jsondataformat.controller;

import com.gx.jsondataformat.model.Contact;
import com.gx.jsondataformat.model.ContactWithJavaUtilDate;
import com.gx.jsondataformat.model.PlainContact;
import com.gx.jsondataformat.model.PlainContactWithJavaUtilDate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/contacts")
public class ContactController {

    @GetMapping
    public List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();

        Contact contact1 = new Contact("张三", "北京", "58298926", LocalDate.now(), LocalDateTime.now());
        Contact contact2 = new Contact("李四", "上海", "58298564", LocalDate.now(), LocalDateTime.now());
        Contact contact3 = new Contact("王五", "山东", "7758964", LocalDate.now(), LocalDateTime.now());

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);

        return contacts;
    }

    @GetMapping("/javaUtilDate")
    public List<ContactWithJavaUtilDate> getContactsWithJavaUtilDate() {
        List<ContactWithJavaUtilDate> contacts = new ArrayList<>();

        ContactWithJavaUtilDate contact1 = new ContactWithJavaUtilDate("张三", "北京", "58298926", new Date(), new Date());
        ContactWithJavaUtilDate contact2 = new ContactWithJavaUtilDate("李四", "上海", "58298564", new Date(), new Date());
        ContactWithJavaUtilDate contact3 = new ContactWithJavaUtilDate("王五", "山东", "7758964", new Date(), new Date());

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);

        return contacts;
    }
    @GetMapping("/plain")
    public List<PlainContact> getPlainContacts() {
        List<PlainContact> contacts = new ArrayList<>();

        PlainContact contact1 = new PlainContact("John Doe", "123 Sesame Street", "123-456-789", LocalDate.now(), LocalDateTime.now());
        PlainContact contact2 = new PlainContact("John Doe 2", "124 Sesame Street", "123-456-789", LocalDate.now(), LocalDateTime.now());
        PlainContact contact3 = new PlainContact("John Doe 3", "125 Sesame Street", "123-456-789", LocalDate.now(), LocalDateTime.now());

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);

        return contacts;
    }

    @GetMapping("/plainWithJavaUtilDate")
    public List<PlainContactWithJavaUtilDate> getPlainContactsWithJavaUtilDate() {
        List<PlainContactWithJavaUtilDate> contacts = new ArrayList<>();

        PlainContactWithJavaUtilDate contact1 = new PlainContactWithJavaUtilDate("John Doe", "123 Sesame Street", "123-456-789", new Date(), new Date());
        PlainContactWithJavaUtilDate contact2 = new PlainContactWithJavaUtilDate("John Doe 2", "124 Sesame Street", "123-456-789", new Date(), new Date());
        PlainContactWithJavaUtilDate contact3 = new PlainContactWithJavaUtilDate("John Doe 3", "125 Sesame Street", "123-456-789", new Date(), new Date());

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);

        return contacts;
    }
}
