package com.project.todo.domain.auth.service;

import com.project.todo.domain.auth.domain.RefreshToken;
import com.project.todo.domain.auth.dto.response.GetTokenResponse;
import com.project.todo.domain.auth.provider.JwtTokenProvider;
import com.project.todo.domain.auth.repository.AuthRepository;
import com.project.todo.domain.member.domain.Member;
import com.project.todo.domain.member.dto.request.MemberSignInRequest;
import com.project.todo.domain.member.dto.request.MemberSignUpRequest;
import com.project.todo.domain.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Transactional
public class AuthService {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    private final AuthRepository authRepository;

    public void signUp(MemberSignUpRequest memberSignUpRequest) {
        // 이메일 중복 검사
        memberService.checkEmailDuplication(memberSignUpRequest.getEmail());
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(memberSignUpRequest.getPassword());
        // 회원 저장
        Member member = memberSignUpRequest.toEntity(encodedPassword);
        memberService.addMember(member);
    }

    @Transactional
    public GetTokenResponse signIn(MemberSignInRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        GetTokenResponse response = jwtTokenProvider.generateToken(authentication);

        RefreshToken refreshToken = RefreshToken.builder()
            .token(response.getRefreshToken())
            .email(request.getEmail())
            .authorities(authentication.getAuthorities())
            .build();

        authRepository.save(refreshToken);

        return jwtTokenProvider.generateToken(authentication);
    }

}
