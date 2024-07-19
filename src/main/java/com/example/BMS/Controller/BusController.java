package com.example.BMS.Controller;

import com.example.BMS.Entity.Bus;
import com.example.BMS.Repositery.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
    @Autowired
    private BusRepository busRepository;
@PostMapping
    public ResponseEntity<Bus> saveBus(@RequestBody Bus bus){

        Bus bus1 = busRepository.save(bus);
        return new ResponseEntity<>(bus1, HttpStatus.OK);
    }
}
