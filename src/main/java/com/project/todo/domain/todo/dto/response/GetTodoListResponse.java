package com.project.todo.domain.todo.dto.response;

import com.project.todo.domain.todo.domain.Todo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetTodoListResponse {
    private Long todoId;
    private String title;
    private boolean isChecked;
    private String dueDate;
    private Long memberId;

    public static GetTodoListResponse from(Long todoId, String title, boolean isChecked, String dueDate, Long memberId) {
        return GetTodoListResponse.builder()
                .todoId(todoId)
                .title(title)
                .isChecked(isChecked)
                .dueDate(dueDate)
                .memberId(memberId)
                .build();
    }

    public static List<GetTodoListResponse> listOf(List<Todo> todoList) {
        return todoList.stream().map(todo -> GetTodoListResponse.builder()
                .todoId(todo.getId())
                .title(todo.getTitle())
                .isChecked(todo.isChecked())
                .dueDate(todo.getDueDate().toString())
                .memberId(todo.getMember().getId())
                .build())
            .collect(Collectors.toList());
    }
}
