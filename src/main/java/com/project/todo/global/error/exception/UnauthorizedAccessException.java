package com.project.todo.global.error.exception;

import com.project.todo.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class UnauthorizedAccessException extends IllegalArgumentException {
    private final ErrorCode errorCode;

    public UnauthorizedAccessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
