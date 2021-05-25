package com.example.endspring.controller;

//import com.example.endspring.domain.Order;
import com.example.endspring.domain.Order;
import com.example.endspring.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RestController
@RequestMapping("/api/order")
public class OrderController extends BaseController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Order Order ) {
        return buildResponse(orderService.add(Order), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam long id) {
        return buildResponse(orderService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return buildResponse(orderService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestParam Long id, Date purchaseDate) {
        return buildResponse(orderService.update(id, purchaseDate), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam long id) {
        return buildResponse(orderService.delete(id), HttpStatus.OK);
    }
}
