package com.example.endspring.controller;

import com.example.endspring.domain.Pharmacy;
import com.example.endspring.service.PharmacyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/pharmacy")
public class PharmacyController extends BaseController {
    private final PharmacyService pharmacyService;

    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Pharmacy pharmacy ) {
        return buildResponse(pharmacyService.add(pharmacy), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam long id) {
        return buildResponse(pharmacyService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return buildResponse(pharmacyService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestParam Long id, String name) {
        return buildResponse(pharmacyService.update(id, name), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam long id) {
        return buildResponse(pharmacyService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<?> findByName(@RequestParam String name) {
        return buildResponse(pharmacyService.findByName(name), HttpStatus.OK);
    }
}
