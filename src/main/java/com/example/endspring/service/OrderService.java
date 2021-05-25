package com.example.endspring.service;

import com.example.endspring.domain.Order;
import com.example.endspring.repo.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    public Order add(Order order) {
        return orderRepository.save(order);
    }

    public Order findById(long id) {
        return orderRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public boolean update(Long id, Date purchaseDate) {
        try {
            Order order = orderRepository.findById(id).orElseThrow(NoSuchElementException::new);
            order.setPurchaseDate(purchaseDate);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean delete(long id) {
        try {
            orderRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
//        order.setDeletedAt(date);
    }
}
