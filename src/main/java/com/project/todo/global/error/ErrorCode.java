package com.project.todo.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // Global
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "G001", "서버 오류"),
    INPUT_INVALID_VALUE(HttpStatus.BAD_REQUEST, "G002", "잘못된 입력"),

    // Member
    EMAIL_DUPLICATE_ERROR(HttpStatus.BAD_REQUEST, "M001", "이미 사용중인 이메일입니다.");

    private final HttpStatus status;
    private final String errorCode;
    private final String message;
}
