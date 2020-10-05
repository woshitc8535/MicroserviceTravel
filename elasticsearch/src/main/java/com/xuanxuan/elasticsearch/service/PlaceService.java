package com.xuanxuan.elasticsearch.service;


import com.xuanxuan.commonconfig.domain.OperationResponse;
import com.xuanxuan.elasticsearch.domain.Place;

import java.util.List;

public interface PlaceService {
    OperationResponse insert(Place place);
    OperationResponse insert(List<Place> places);
    OperationResponse delete(Place place);
    Place findPlaceById(String id);
}
