package com.xuanxuan.eurekaclient.service;


import com.xuanxuan.eurekaclient.domain.Place;

import java.io.IOException;

public interface SearchService {
    Place search(String placeName) throws IOException, InterruptedException;
}
