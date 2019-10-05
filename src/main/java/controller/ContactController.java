package controller;

import dbrepository.ContactRepository;
import dbrepository.ProspectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.Contact;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/Contact/all")
    public List<Contact> getContact() {
        return contactRepository.findAll();
    }

    @GetMapping("/Contact/{name}")
    public Contact getContact(@PathVariable("name") String name) {
        return contactRepository.findAllByName(name);
    }

    @GetMapping("/Contact/")
    public List<Contact> getContacts(@RequestParam String name) {
        return contactRepository.findAllByAndName(name);
    }

    @PostMapping("/Contact")
    public void postContact(@RequestBody Contact contact) {
        contactRepository.save(contact);
    }


    @PutMapping("/Contact/{name}")
    public void putContact(@PathVariable("name") String name, @Valid @RequestBody Contact contact) {
        contact.setName(name);
        contactRepository.save(contact);
    }

    @DeleteMapping("/Contact/{name}")
    public void deleteContact(@PathVariable("name") String name){
        contactRepository.deleteByName(name);
    }

    @GetMapping("/test")
    public String test(){
        return "Hello Pivotal";
    }
}