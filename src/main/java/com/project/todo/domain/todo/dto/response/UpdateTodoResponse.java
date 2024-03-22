package com.project.todo.domain.todo.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class UpdateTodoResponse {
    private Long id;

    public static UpdateTodoResponse from(Long id) {
        return UpdateTodoResponse.builder()
                .id(id)
                .build();
    }
}
