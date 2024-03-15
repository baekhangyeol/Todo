package com.project.todo.global.error.exception;

import com.project.todo.global.error.ErrorCode;
import lombok.Getter;
import org.springframework.dao.EmptyResultDataAccessException;

@Getter
public class EmptyResultDataException extends EmptyResultDataAccessException {
    private final ErrorCode errorCode;

    public EmptyResultDataException(ErrorCode errorCode) {
        super(errorCode.getMessage(), 1);
        this.errorCode = errorCode;
    }
}
