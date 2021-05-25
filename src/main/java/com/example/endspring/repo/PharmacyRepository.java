package com.example.endspring.repo;

import com.example.endspring.domain.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
    Optional<Pharmacy> findById(Long id);
    Optional<Pharmacy> findByName(String name);
    List<Pharmacy> findAll();
}
