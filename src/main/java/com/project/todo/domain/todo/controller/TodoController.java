package com.project.todo.domain.todo.controller;

import com.project.todo.domain.member.domain.Member;
import com.project.todo.domain.todo.dto.request.CreateTodoRequest;
import com.project.todo.domain.todo.dto.request.UpdateTodoRequest;
import com.project.todo.domain.todo.dto.response.CreateTodoResponse;
import com.project.todo.domain.todo.dto.response.UpdateTodoResponse;
import com.project.todo.domain.todo.service.TodoService;
import com.project.todo.global.common.annotation.LoginUser.LoginUser;
import com.project.todo.global.result.ResultCode;
import com.project.todo.global.result.ResultResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(ResultResponse.of(ResultCode.TODO_CREATE_SUCCESS, response));
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<ResultResponse> updateTodo(@PathVariable Long todoId, @Validated @RequestBody UpdateTodoRequest request, @LoginUser Member member) {
        UpdateTodoResponse response = todoService.updateTodo(todoId, request, member);
        return ResponseEntity.status(HttpStatus.OK)
            .body(ResultResponse.of(ResultCode.TODO_UPDATE_SUCCESS, response));
    }
}
