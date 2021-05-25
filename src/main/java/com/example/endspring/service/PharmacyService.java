package com.example.endspring.service;

import com.example.endspring.domain.Pharmacy;
import com.example.endspring.repo.PharmacyRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PharmacyService {
    private final PharmacyRepository pharmacyRepository;

    public PharmacyService(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    public Pharmacy add(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }

    public Pharmacy findById(long id) {
        return pharmacyRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Pharmacy> findAll() {
        return pharmacyRepository.findAll();
    }

    public boolean update(Long id, String name) {
        try {
            Pharmacy pharmacy = pharmacyRepository.findById(id).orElseThrow(NoSuchElementException::new);
            pharmacy.setName(name);
            pharmacyRepository.save(pharmacy);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean delete(long id) {
        try {
            pharmacyRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Pharmacy findByName(String name) {
        return pharmacyRepository.findByName(name).orElseThrow(NoSuchElementException::new);
    }
}
