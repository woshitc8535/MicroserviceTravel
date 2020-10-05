package com.xuanxuan.eurekaclient.service.serviceImp;

import com.xuanxuan.eurekaclient.domain.Place;
import com.xuanxuan.eurekaclient.service.PlaceService;
import com.xuanxuan.eurekaclient.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import se.walkercrou.places.GooglePlaces;

import java.util.List;


@Service
public class SearchServiceImp implements SearchService {

    @Autowired
    private PlaceService placeService;

    @Bean
    public GooglePlaces gClient() {
        return new GooglePlaces("AIzaSyAG0UcNy-lMzVJeatzIed__CVSOdeVTW1w");
    }

    @Override
    public Place search(String placeName) {
        List<se.walkercrou.places.Place> places = gClient().getPlacesByQuery(placeName, GooglePlaces.MAXIMUM_RESULTS);

        System.out.println(1);

        if (places == null) {
            return null;
        }
        else {
            Place place = new Place();
            place.setPlaceId(places.get(0).getPlaceId());
            place.setPlaceName(places.get(0).getName());
            place.setLat(places.get(0).getLatitude());
            place.setLon(places.get(0).getLongitude());

            placeService.insertPlace(place);

            return place;
        }
    }
}
