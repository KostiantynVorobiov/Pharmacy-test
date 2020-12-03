package com.clients.pharmacy.service;

import com.clients.pharmacy.entity.Family;
import com.clients.pharmacy.entity.User;
import com.clients.pharmacy.repository.FamilyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FamilyServiceImpl {
    private final FamilyRepository familyRepository;

    public FamilyServiceImpl(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    // for checking findBySecondName method
    public void add(){
        User bob = new User();
        bob.setFirstName("Bob");
        bob.setSecondName("Pupkin");
        User alice = new User();
        alice.setFirstName("Alice");
        alice.setSecondName("Pupkin");
        List<User> userList = List.of(bob, alice);
        Family first = new Family();
        first.setSurname(bob.getSecondName());
        first.setMembers(userList);
        familyRepository.save(first);

        User john = new User();
        john.setFirstName("John");
        john.setSecondName("Ivanov");
        User ana = new User();
        alice.setFirstName("Anna");
        alice.setSecondName("Ivanov");
        List<User> userList2 = List.of(john, ana);
        Family second = new Family();
        second.setSurname(john.getSecondName());
        second.setMembers(userList2);
        familyRepository.save(second);

    }

    public List<Family> getAll(){
        return familyRepository.findAll();
    }

    public Family findBySecondName(String name){
        return familyRepository.findBySurname(name);
    }
}
