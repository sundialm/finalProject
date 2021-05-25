package com.example.endspring.controller;
import com.example.endspring.domain.Buyer;
import com.example.endspring.service.BuyerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/buyer")
@AllArgsConstructor
public class BuyerController extends BaseController {

    private final BuyerService buyerService;



    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Buyer buyer ) {
        return buildResponse(buyerService.add(buyer), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam long id) {
        return buildResponse(buyerService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return buildResponse(buyerService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateAll(@RequestParam Long id, String name, String address, Integer phoneNumber) {
        return buildResponse(buyerService.update(id, name, address, phoneNumber), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam long id) {
        return buildResponse(buyerService.delete(id), HttpStatus.OK);
    }

}
