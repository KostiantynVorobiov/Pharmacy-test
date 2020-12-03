package com.clients.pharmacy.service;

import com.clients.pharmacy.entity.Family;
import com.clients.pharmacy.repository.FamilyRepository;
import org.springframework.stereotype.Service;

@Service
public class FamilyServiceImpl {
    private final FamilyRepository familyRepository;

    public FamilyServiceImpl(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    public Family findBySecondName(String name) {
        return familyRepository.findBySurname(name);
    }
}
