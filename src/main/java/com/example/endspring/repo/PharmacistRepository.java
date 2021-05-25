package com.example.endspring.repo;

import com.example.endspring.domain.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {
    Optional<Pharmacist> findById(Long id);
    List<Pharmacist> findAll();
    Optional<Pharmacist>  findByName(String name);
    Optional<Pharmacist>  findByPhoneNumber(String phoneNumber);
}
