package com.project.todo.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    // Auth
    AUTH_SIGNUP_SUCCESS("A001", "회원가입에 성공하였습니다."),
    AUTH_LOGIN_SUCCESS("A002", "로그인에 성공하였습니다."),
    AUTH_LOGOUT_SUCCESS("A003", "로그아웃에 성공하였습니다."),

    // Todo
    TODO_CREATE_SUCCESS("T001", "Todo를 생성하였습니다."),
    TODO_UPDATE_SUCCESS("T002", "Todo를 수정하였습니다.");

    private final String code;
    private final String message;
}
