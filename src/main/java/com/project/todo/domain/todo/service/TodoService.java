package com.project.todo.domain.todo.service;

import com.project.todo.domain.member.domain.Member;
import com.project.todo.domain.todo.domain.Todo;
import com.project.todo.domain.todo.dto.request.CreateTodoRequest;
import com.project.todo.domain.todo.dto.response.CreateTodoResponse;
import com.project.todo.domain.todo.repository.TodoRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class TodoService {
    private final TodoRepository todoRepository;

    public CreateTodoResponse createTodo(CreateTodoRequest request, Member member) {
        Todo entity = request.toEntity(member);
        Todo todo = todoRepository.save(entity);
        return CreateTodoResponse.from(todo.getId());
    }
}
