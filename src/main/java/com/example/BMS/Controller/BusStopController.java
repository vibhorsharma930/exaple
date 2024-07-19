package com.example.BMS.Controller;

import com.example.BMS.Entity.Bus;
import com.example.BMS.Entity.BusStop;
import com.example.BMS.Entity.Stop;
import com.example.BMS.Repositery.BusRepository;
import com.example.BMS.Repositery.BusStopRepository;
import com.example.BMS.Repositery.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/busstop")
public class BusStopController {
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private StopRepository stopRepository;
    @Autowired
    private BusStopRepository busStopRepository;
@PostMapping
    public ResponseEntity<?> createMapping(@RequestParam(name="bid") long bid,
                                           @RequestParam(name="sid") long sid,
                                           @RequestBody BusStop busStop){



    System.out.println(bid);
    System.out.println(sid);
        Optional<Bus> byId = busRepository.findById(bid);
        Bus bus = byId.get();


        Optional<Stop> byId1 = stopRepository.findById(sid);
        Stop stop1 = byId1.get();

        busStop.setBus(bus);
        busStop.setStop(stop1);

        BusStop busStop1 = busStopRepository.save(busStop);

        return new ResponseEntity<>(busStop1, HttpStatus.OK);
    }

}
