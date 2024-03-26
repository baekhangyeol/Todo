package com.project.todo.domain.follow.controller;

import com.project.todo.domain.follow.service.FollowService;
import com.project.todo.domain.member.domain.Member;
import com.project.todo.global.common.annotation.LoginUser.LoginUser;
import com.project.todo.global.result.ResultCode;
import com.project.todo.global.result.ResultResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/follows")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class FollowController {
    private final FollowService followService;

    @PostMapping("/{following}")
    public ResponseEntity<ResultResponse> addFollow(@PathVariable Long following, @LoginUser Member member) {
        followService.addFollow(following, member);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(ResultResponse.of(ResultCode.FOLLOW_CREATE_SUCCESS));
    }

    @DeleteMapping("/{following}")
    public ResponseEntity<ResultResponse> deleteFollow(@PathVariable Long following, @LoginUser Member member) {
        followService.deleteFollow(following, member);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body(ResultResponse.of(ResultCode.FOLLOW_DELETE_SUCCESS));
    }
}
