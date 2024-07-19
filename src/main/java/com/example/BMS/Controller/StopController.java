package com.example.BMS.Controller;

import com.example.BMS.Entity.Stop;
import com.example.BMS.Repositery.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stop")
public class StopController {

    @Autowired
    private StopRepository stopRepository;
    @PostMapping
    public ResponseEntity<Stop> stopSave(@RequestBody Stop stop){

        Stop stop1 = stopRepository.save(stop);

        return new ResponseEntity<>(stop1, HttpStatus.OK);
    }
}
