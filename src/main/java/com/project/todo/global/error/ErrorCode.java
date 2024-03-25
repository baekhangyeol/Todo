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
    EMAIL_DUPLICATE_ERROR(HttpStatus.BAD_REQUEST, "M001", "이미 사용중인 이메일입니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "M002", "사용자를 찾을 수 없습니다."),

    // Todo
    TODO_NOT_FOUND(HttpStatus.NOT_FOUND, "T001", "Todo을 찾을 수 없습니다."),
    TODO_NOT_ACCESS(HttpStatus.FORBIDDEN, "T002", "Todo에 접근할 수 없습니다.");

    private final HttpStatus status;
    private final String errorCode;
    private final String message;
}
