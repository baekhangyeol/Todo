package com.project.todo.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    // Auth
    AUTH_SIGNUP_SUCCESS("A001", "회원가입에 성공하였습니다."),
    AUTH_SIGNIN_SUCCESS("A002", "로그인에 성공하였습니다.");

    private final String code;
    private final String message;
}
