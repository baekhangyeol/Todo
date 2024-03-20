package com.project.todo.domain.todo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTodoResponse {
    private Long todoId;

    public static CreateTodoResponse from(Long todoId) {
        return CreateTodoResponse.builder()
                .todoId(todoId)
                .build();
    }
}
