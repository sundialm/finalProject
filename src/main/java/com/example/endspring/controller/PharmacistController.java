package com.example.endspring.controller;

import com.example.endspring.domain.Pharmacist;
import com.example.endspring.service.PharmacistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/pharmacist")
public class PharmacistController extends BaseController {
    private final PharmacistService pharmacistService;

    public PharmacistController(PharmacistService pharmacistService) {
        this.pharmacistService = pharmacistService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Pharmacist pharmacist ) {
        return buildResponse(pharmacistService.add(pharmacist), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam long id) {
        return buildResponse(pharmacistService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return buildResponse(pharmacistService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateAll(@RequestParam Long id, String name, String phoneNumber) {
        return buildResponse(pharmacistService.updateAll(id, name, phoneNumber), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam long id) {
        return buildResponse(pharmacistService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<?> findByName(@RequestParam String name) {
        return buildResponse(pharmacistService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/findByPhoneNumber")
    public ResponseEntity<?> findByPhoneNumber(@RequestParam String phoneNumber) {
        return buildResponse(pharmacistService.findByPhoneNumber(phoneNumber), HttpStatus.OK);
    }
}
