package com.project.todo.domain.auth.controller;

import com.project.todo.domain.auth.dto.request.LogoutRequest;
import com.project.todo.domain.auth.dto.response.GetTokenResponse;
import com.project.todo.domain.auth.service.AuthService;
import com.project.todo.domain.member.dto.request.MemberSignInRequest;
import com.project.todo.domain.member.dto.request.MemberSignUpRequest;
import com.project.todo.global.result.ResultCode;
import com.project.todo.global.result.ResultResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name= "Auth", description = "인증 API")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<ResultResponse> signUp(@Validated @RequestBody MemberSignUpRequest memberSignUpRequest) {
        authService.signUp(memberSignUpRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(ResultResponse.of(ResultCode.AUTH_SIGNUP_SUCCESS));
    }

    @PostMapping("/login")
    public ResponseEntity<ResultResponse> login(@Validated @RequestBody MemberSignInRequest memberSignInRequest) {
        GetTokenResponse response = authService.signIn(memberSignInRequest);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.AUTH_LOGIN_SUCCESS, response));
    }

    @PostMapping("logout")
    public ResponseEntity<ResultResponse> logout(@Validated @RequestBody LogoutRequest request) {
        authService.logout(request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body(ResultResponse.of(ResultCode.AUTH_LOGIN_SUCCESS));
    }
}
