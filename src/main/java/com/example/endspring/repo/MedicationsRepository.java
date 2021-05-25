package com.example.endspring.repo;


import com.example.endspring.domain.Medications;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MedicationsRepository extends JpaRepository<Medications, Long> {
    Optional<Medications> findById( Long id);
    List<Medications> findAll();
    Optional<Medications> findByName(String name);
    Optional<List<Medications>> findByPrice(Integer price);

}
