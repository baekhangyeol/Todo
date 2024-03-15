package com.project.todo.domain.member.dto.request;

import com.project.todo.domain.member.domain.Member;
import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class MemberSignUpRequest {
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    public Member toEntity(String encodedPassword) {
        return Member.builder()
                .email(email)
                .password(encodedPassword)
                .build();
    }
}
