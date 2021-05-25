package com.example.endspring.service;

import com.example.endspring.domain.Medications;
import com.example.endspring.repo.MedicationsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@AllArgsConstructor
public class MedicationsService {

    private final MedicationsRepository medicationsRepository;


    public Medications add(Medications medications) {
        return medicationsRepository.save(medications);
    }

    public Medications findById(long id) {
        return medicationsRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Medications> findAll() {
        return medicationsRepository.findAll();
    }

    public boolean update(Long id, String name, Integer price, Date dueDate) {
        try {
            Medications medications = medicationsRepository.findById(id).orElseThrow(NoSuchElementException::new);
            medications.setName(name);
            medications.setPrice(price);
            medications.setDueDate(dueDate);
            medicationsRepository.save(medications);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean delete(long id) {
        try {
            medicationsRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    public Medications findByName(String name) {
        return medicationsRepository.findByName(name).orElseThrow(NoSuchElementException::new);
    }

    public List<Medications> findByPrice(int price) {
        return medicationsRepository.findByPrice(price).orElseThrow( NoSuchElementException::new);
    }

}
