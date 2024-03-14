package com.project.todo.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // Global
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "G001", "서버 오류"),
    INPUT_INVALID_VALUE(HttpStatus.BAD_REQUEST, "G002", "잘못된 입력");

    private final HttpStatus status;
    private final String errorCode;
    private final String message;
}
