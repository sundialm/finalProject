package com.example.endspring.service;

import com.example.endspring.domain.Pharmacist;
import com.example.endspring.repo.PharmacistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class PharmacistService {

    private final PharmacistRepository pharmacistRepository;


    public Pharmacist add(Pharmacist pharmacist) {
        return pharmacistRepository.save(pharmacist);
    }

    public Pharmacist findById(long id) {
        return   pharmacistRepository.findById(id).orElseThrow( NoSuchElementException::new);
    }

    public List<Pharmacist> findAll() {
        return pharmacistRepository.findAll();
    }

    public String updateAll(Long id, String name, String phoneNumber) {
        Pharmacist pharmacist = pharmacistRepository.findById(id).orElseThrow( NoSuchElementException::new);
        pharmacist.setName(name);
        pharmacist.setPhoneNumber(phoneNumber);
        pharmacistRepository.save(pharmacist);
        return "updated all";
    }

    public String delete(long id) {
        Date date = new Date();
        Pharmacist pharmacist = pharmacistRepository.findById(id).orElseThrow( NoSuchElementException::new);
//        pharmacist.setDeletedAt(date);
        pharmacistRepository.save(pharmacist);
        return "deleted";
    }

    public Pharmacist findByName(String name) {
        return pharmacistRepository.findByName(name).orElseThrow( NoSuchElementException::new);
    }

    public Pharmacist findByPhoneNumber(String phoneNumber) {
        return pharmacistRepository.findByPhoneNumber(phoneNumber).orElseThrow( NoSuchElementException::new);
    }
}
