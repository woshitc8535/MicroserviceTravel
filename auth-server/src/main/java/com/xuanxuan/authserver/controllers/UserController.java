package com.xuanxuan.authserver.controllers;


import com.xuanxuan.authserver.entity.User;
import com.xuanxuan.authserver.jwtUtils.JwtTokenProvider;
import com.xuanxuan.authserver.model.LoginRequestModel;
import com.xuanxuan.authserver.model.LoginResponse;
import com.xuanxuan.authserver.model.OperationResponse;
import com.xuanxuan.authserver.model.UserInfoModel;
import com.xuanxuan.authserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final String wrongEmailPasswordError = "Incorrect email or password";

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequestModel loginRequestModel) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequestModel.getEmail(), loginRequestModel.getPassword());

        LoginResponse ans = new LoginResponse();

        try{
            authenticationManager.authenticate(authenticationToken);
        } catch(Exception e) {
            ans.setOperationResponse(OperationResponse.getFailedResponse(wrongEmailPasswordError));
            System.out.println(e.toString());
            return new ResponseEntity<>(ans, HttpStatus.UNAUTHORIZED);
        }
        String token = jwtTokenProvider.generateToken(authenticationToken);
        User user = userService.findByEmail(loginRequestModel.getEmail());
        UserInfoModel model = new UserInfoModel();
        model.setName(user.getUsername());
        model.setEmail(user.getEmail());
        ans.setToken(token);
        ans.setOperationResponse(OperationResponse.getSuccessResponse());
        return ResponseEntity.ok(ans);
    }



    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findByEmail(user.getEmail()) != null) {
            return new ResponseEntity<>("User Already Exist", HttpStatus.CONFLICT);
        }
        userService.saveUser(user);
        return new ResponseEntity<>("Create Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public String test() {
        System.out.println("111");
        return "test";
    }
}
