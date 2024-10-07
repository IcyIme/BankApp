package com.grade.BankAppAPI.Service.Implemetation;

import com.grade.BankAppAPI.Dto.Response;
import com.grade.BankAppAPI.Dto.UserRequest;
import com.grade.BankAppAPI.Dto.AccountInfo;
import com.grade.BankAppAPI.Entity.User;
import com.grade.BankAppAPI.Repository.UserRepository;
import com.grade.BankAppAPI.Utils.AccountUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImplemetation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Response createAccount(UserRequest userRequest) {
        //vytvaranie noveho uctu

        if(userRepository.ExistsByEmail(userRequest.getEmail())){
            Response response = Response.builder()
                    .code(AccountUtilities.AccountExistsCode)
                    .message(AccountUtilities.AccountExistsCode)
                    .info(null)
                    .build();
            return response;
        }else{
            var createdUser = User.builder()
                    .firtsName(userRequest.getFirtsName())
                    .otherName(userRequest.getOtherName())
                    .lastName(userRequest.getLastName())
                    .email(userRequest.getEmail())
                    .gender(userRequest.getGender())
                    .address(userRequest.getAddress())
                    .stateOfOrigin(userRequest.getStateOfOrigin())
                    .accountNumber(AccountUtilities.generateValidAccountNumber(16))
                    .balance(BigDecimal.ZERO)
                    .status("ACTIVE")
                    .phoneNumber(userRequest.getPhoneNumber())
                    .alternatePhoneNumber(userRequest.getAlternatePhoneNumber())
                    .build();

            var savedUser = userRepository.save(createdUser);
            return Response.builder()
                    .code(AccountUtilities.AccountCreatedMessage)
                    .message(AccountUtilities.AccountCreatedMessage)
                    .info(AccountInfo.builder()
                            .accountNumber(savedUser.getAccountNumber())
                            .balance(savedUser.getBalance())
                            .name(savedUser.getFirtsName() + " " + savedUser.getLastName() + " " + createdUser.getOtherName())
                            .build())
                    .build();
        }
    }
}
