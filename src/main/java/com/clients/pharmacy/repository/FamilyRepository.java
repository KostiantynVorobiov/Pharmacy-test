package com.clients.pharmacy.repository;

import com.clients.pharmacy.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {
    Family findBySurname(String surname);
}
