package com.xuanxuan.eurekaclient.controller;


import com.xuanxuan.commonconfig.domain.OperationResponse;
import com.xuanxuan.eurekaclient.domain.Place;
import com.xuanxuan.eurekaclient.domain.User;
import com.xuanxuan.eurekaclient.model.SearchPlaceModel;
import com.xuanxuan.eurekaclient.service.PlaceService;
import com.xuanxuan.eurekaclient.service.SearchService;
import com.xuanxuan.eurekaclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private PlaceService placeService;

    @GetMapping("/test")
    public String test() {
        return "test";
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/insertPlace")
    public ResponseEntity<?> insertPlace(@RequestBody Place place) {
        placeService.insertPlace(place);
        return new ResponseEntity<>("successful", HttpStatus.OK);
    }

    @PostMapping("/insertPlaces")
    public ResponseEntity<?> insertPlace(@RequestBody List<Place> places) {
        return placeService.insertPlace(places);
    }

    @PostMapping("/deletePlace")
    public ResponseEntity<?> deletePlace(@RequestBody Place place) {
        return placeService.deletePlace(place);
    }

    @PostMapping("/searchPlace")
    public ResponseEntity<?> searchPlace(@RequestBody SearchPlaceModel model) {
        try {
            System.out.println(model.getPlaceName());
            searchService.search(model.getPlaceName());
            return new ResponseEntity<>(OperationResponse.getSuccessResponse(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(OperationResponse.getFailedResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






}
