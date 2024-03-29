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
    TODO_UPDATE_SUCCESS("T002", "Todo를 수정하였습니다."),
    TODO_DELETE_SUCCESS("T003", "Todo를 삭제하였습니다."),
    TODO_GET_SUCCESS("T004", "Todo 목록을 조회하였습니다."),

    // Follow
    FOLLOW_CREATE_SUCCESS("F001", "팔로우를 추가하였습니다."),
    FOLLOW_DELETE_SUCCESS("F002", "팔로우를 삭제하였습니다."),
    FOLLOWER_GET_SUCCESS("F003", "팔로워 목록을 조회하였습니다."),
    FOLLOWING_GET_SUCCESS("F004", "팔로잉 목록을 조회하였습니다.");

    private final String code;
    private final String message;
}
