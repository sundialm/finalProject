package com.example.endspring.repo;

import com.example.endspring.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {

    void deleteById(long id);

    List<Buyer> findAll();
}
