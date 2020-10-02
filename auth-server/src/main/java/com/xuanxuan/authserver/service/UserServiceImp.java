package com.xuanxuan.authserver.service;

import com.xuanxuan.authserver.model.OperationResponse;
import com.xuanxuan.authserver.model.UserInfoModel;
import com.xuanxuan.authserver.entity.User;
import com.xuanxuan.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public OperationResponse saveUser(User user) {
        OperationResponse res = new OperationResponse();
        if (userRepository.findUserByEmail(user.getEmail()).isPresent()) {
            return OperationResponse.getFailedResponse("Email Already been taken");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserInfoModel model = new UserInfoModel();
        model.setEmail(user.getEmail());
        model.setName(user.getUsername());
        userRepository.save(user);
        return OperationResponse.getSuccessResponse();
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findUserByEmail(email).orElse(null);
        return user;
    }
}
