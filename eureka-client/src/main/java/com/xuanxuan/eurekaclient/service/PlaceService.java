package com.xuanxuan.eurekaclient.service;


import com.xuanxuan.eurekaclient.domain.Place;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(value = "elasticsearch")
public interface PlaceService {
    @PostMapping("/insertPlace")
    public ResponseEntity<?> insertPlace(@RequestBody Place place);

    @PostMapping("/insertPlaces")
    public ResponseEntity<?> insertPlace(@RequestBody List<Place> places);

    @PostMapping("/deletePlace")
    public ResponseEntity<?> deletePlace(@RequestBody Place place);


}
