package com.project.todo.domain.todo.controller;

import com.project.todo.domain.member.domain.Member;
import com.project.todo.domain.todo.dto.request.CreateTodoRequest;
import com.project.todo.domain.todo.dto.response.CreateTodoResponse;
import com.project.todo.domain.todo.service.TodoService;
import com.project.todo.global.common.annotation.LoginUser.LoginUser;
import com.project.todo.global.result.ResultCode;
import com.project.todo.global.result.ResultResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/todos")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<ResultResponse> createTodo(@Validated @RequestBody CreateTodoRequest request, @LoginUser Member member) {
        CreateTodoResponse response = todoService.createTodo(request, member);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.TODO_CREATE_SUCCESS, response));
    }
}
