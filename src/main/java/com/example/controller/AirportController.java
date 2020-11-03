package com.example.controller;

import com.example.dto.AirportInfo;
import com.example.exception.FlightNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
public class AirportController {

    private List<AirportInfo> airportInfoList = new ArrayList<>();
    private static final String SERVICE_WARNING_MESSAGE = "Berlin Schönefeld is closed for service today";
    private static final String NOT_FOUND_MESSAGE = "Information not found for number";

    public AirportController() {
        airportInfoList.add(new AirportInfo("Berlin Teggel", "TXL", "EDDT"));
        airportInfoList.add(new AirportInfo("Berlin Schönefeld", "SXF", "EDDB"));
    }

    @GetMapping("airports/{id}")
    public AirportInfo getAirportInfo(@PathVariable int id) {
        AirportInfo airportInfo = airportInfoList.get(id);
        if (Objects.equals(airportInfo.getName(), "Berlin Schönefeld")) {
            throw new FlightNotFoundException("Flight not found for id =" + id);
        }
        return airportInfo;
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public HashMap<String, String> handleIndexOutOfBoundsException(Exception e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", NOT_FOUND_MESSAGE);
        response.put("error", e.getClass().getSimpleName());
        return response;
    }
}
