package com.example.endspring.controller;

import com.example.endspring.domain.Medications;
import com.example.endspring.service.MedicationsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RestController
@RequestMapping("/api/medications")
public class MedicationsController extends BaseController {
    private final MedicationsService medicationsService;

    public MedicationsController(MedicationsService medicationsService) {
        this.medicationsService = medicationsService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Medications medications ) {
        return buildResponse(medicationsService.add(medications), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam long id) {
        return buildResponse(medicationsService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return buildResponse(medicationsService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateAll(@RequestParam Long id, String name, Integer price, Date dueDate) {
        return buildResponse(medicationsService.update(id, name, price, dueDate), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam long id) {
        return buildResponse(medicationsService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<?> findByName(@RequestParam String name) {
        return buildResponse(medicationsService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/findByPrice")
    public ResponseEntity<?> findByPrice(@RequestParam int price) {
        return buildResponse(medicationsService.findByPrice(price), HttpStatus.OK);
    }
}
