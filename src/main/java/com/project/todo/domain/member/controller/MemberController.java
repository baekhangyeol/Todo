package com.project.todo.domain.member.controller;

import com.project.todo.domain.follow.service.FollowService;
import com.project.todo.global.result.ResultCode;
import com.project.todo.global.result.ResultResponse;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberController {
    private final FollowService followService;

    @GetMapping("/{id}/followers")
    public ResponseEntity<ResultResponse> getFollowers(@PathVariable Long id) {
        List<String> followers = followService.findFollowers(id);
        return ResponseEntity.status(HttpStatus.OK)
            .body(ResultResponse.of(ResultCode.FOLLOWER_GET_SUCCESS, followers));
    }

    @GetMapping("/{id}/followings")
    public ResponseEntity<ResultResponse> getFollowings(@PathVariable Long id) {
        List<String> followings = followService.findFollowings(id);
        return ResponseEntity.status(HttpStatus.OK)
            .body(ResultResponse.of(ResultCode.FOLLOWING_GET_SUCCESS, followings));
    }
}
