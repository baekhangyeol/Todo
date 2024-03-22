package com.project.todo.domain.todo.service;

import com.project.todo.domain.member.domain.Member;
import com.project.todo.domain.todo.domain.Todo;
import com.project.todo.domain.todo.dto.request.CreateTodoRequest;
import com.project.todo.domain.todo.dto.request.UpdateTodoRequest;
import com.project.todo.domain.todo.dto.response.CreateTodoResponse;
import com.project.todo.domain.todo.dto.response.UpdateTodoResponse;
import com.project.todo.domain.todo.repository.TodoRepository;
import com.project.todo.global.error.ErrorCode;
import com.project.todo.global.error.exception.EmptyResultDataException;
import com.project.todo.global.error.exception.UnauthorizedAccessException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Transactional(readOnly = true)
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public CreateTodoResponse createTodo(CreateTodoRequest request, Member member) {
        Todo entity = request.toEntity(member);
        Todo todo = todoRepository.save(entity);
        return CreateTodoResponse.from(todo.getId());
    }

    @Transactional
    public UpdateTodoResponse updateTodo(Long id, UpdateTodoRequest request, Member member) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new EmptyResultDataException(ErrorCode.TODO_NOT_FOUND));
        if(todo.getMember() != member) throw new UnauthorizedAccessException(ErrorCode.TODO_NOT_ACCESS);
        todo.update(request);
        return UpdateTodoResponse.from(todo.getId());
    }
}
