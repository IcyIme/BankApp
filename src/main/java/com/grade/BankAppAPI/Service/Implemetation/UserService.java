package com.grade.BankAppAPI.Service.Implemetation;

import com.grade.BankAppAPI.Dto.Response;
import com.grade.BankAppAPI.Dto.UserRequest;

public interface UserService {
    Response createAccount(UserRequest userRequest);
}
