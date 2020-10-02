package com.xuanxuan.eurekaclient.service;


import com.xuanxuan.eurekaclient.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "auth-service")
public interface UserService {
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user);
}
