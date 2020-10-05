package com.xuanxuan.elasticsearch.service.imp;


import com.xuanxuan.commonconfig.domain.OperationResponse;
import com.xuanxuan.elasticsearch.domain.Place;
import com.xuanxuan.elasticsearch.repository.PlaceRepository;
import com.xuanxuan.elasticsearch.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImp implements PlaceService {

    @Autowired
    private PlaceRepository repository;

    @Override
    public OperationResponse insert(Place place) {
       if (findPlaceById(place.getPlaceId()) != null) {
           return OperationResponse.getFailedResponse("Place Already Existed");
       }
       repository.save(place);
       return OperationResponse.getSuccessResponse();

    }

    @Override
    public OperationResponse insert(List<Place> places) {
        for (Place place : places) {
            if (findPlaceById(place.getPlaceId()) != null) {
                return OperationResponse.getFailedResponse("Place Already Existed");
            }
            repository.save(place);
        }
        return OperationResponse.getSuccessResponse();
    }

    @Override
    public OperationResponse delete(Place place) {
        if (findPlaceById(place.getPlaceId()) == null) {
            return OperationResponse.getFailedResponse("No Such a place");
        }
        repository.delete(place);
        return OperationResponse.getSuccessResponse();
    }

    @Override
    public Place findPlaceById(String id) {
        Place place = repository.findByPlaceId(id).orElse(null);
        return place;
    }
}
