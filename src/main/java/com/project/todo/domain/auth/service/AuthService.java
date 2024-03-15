package com.project.todo.domain.auth.service;

import com.project.todo.domain.member.domain.Member;
import com.project.todo.domain.member.dto.request.MemberSignUpRequest;
import com.project.todo.domain.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Transactional
public class AuthService {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    public void signUp(MemberSignUpRequest memberSignUpRequest) {
        // 이메일 중복 검사
        memberService.checkEmailDuplication(memberSignUpRequest.getEmail());
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(memberSignUpRequest.getPassword());
        // 회원 저장
        Member member = memberSignUpRequest.toEntity(encodedPassword);
        memberService.addMember(member);
    }

}
