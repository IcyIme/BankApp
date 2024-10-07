package com.grade.BankAppAPI.Controller;

import com.grade.BankAppAPI.Dto.Response;
import com.grade.BankAppAPI.Dto.UserRequest;
import com.grade.BankAppAPI.Service.Implemetation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    public Response createUser(@RequestBody UserRequest userRequest) {
        return userService.createAccount(userRequest);
    }
}
