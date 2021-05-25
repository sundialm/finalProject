package com.example.endspring.service;

import com.example.endspring.domain.Buyer;
import com.example.endspring.repo.BuyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BuyerService {

    private final BuyerRepository buyerRepository;

    public Buyer add(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    public Buyer findById(long id) {
        return buyerRepository.findById(id).orElseThrow( NoSuchElementException::new);
    }

    public List<Buyer> findAll() {
        return buyerRepository.findAll();
    }

    public String update(Long id, String name, String address, Integer phoneNumber) {
        Buyer buyer = buyerRepository.findById(id).orElseThrow( NoSuchElementException::new);
        buyer.setName(name);
        buyer.setAddress(address);
        buyer.setPhoneNumber(phoneNumber);
        buyerRepository.save(buyer);
        return "updated all";
    }

    public boolean delete(long id) {
       try {
          buyerRepository.deleteById(id);
           return  true;
       } catch ( Exception ex) {
           return  false;
       }
    }

}
