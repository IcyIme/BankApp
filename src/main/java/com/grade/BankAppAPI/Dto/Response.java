package com.grade.BankAppAPI.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Response {
    private String code;
    private String message;
    private AccountInfo info;
}
