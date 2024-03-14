package com.project.todo.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    DOMAIN_BEHAVIOR_SUCCESS("EXAMPLE", "예시 코드입니다.");

    private final String code;
    private final String message;
}
