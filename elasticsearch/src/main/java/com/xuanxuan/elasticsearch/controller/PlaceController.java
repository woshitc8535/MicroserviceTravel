package com.xuanxuan.elasticsearch.controller;


import com.xuanxuan.commonconfig.domain.OperationResponse;
import com.xuanxuan.elasticsearch.domain.Place;
import com.xuanxuan.elasticsearch.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaceController {

    @Autowired
    private PlaceService placeService;


    @PostMapping("/insertPlace")
    public ResponseEntity<?> insertPlace(@RequestBody Place place) {
        try {
            OperationResponse res = placeService.insert(place);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(OperationResponse.getFailedResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insertPlaces")
    public ResponseEntity<?> insertPlace(@RequestBody List<Place> places) {
        try {
            OperationResponse res = placeService.insert(places);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(OperationResponse.getFailedResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/deletePlace")
    public ResponseEntity<?> deletePlace(@RequestBody Place place) {
        try {
            OperationResponse res = placeService.delete(place);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(OperationResponse.getFailedResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
