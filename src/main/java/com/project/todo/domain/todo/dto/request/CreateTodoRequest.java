package com.project.todo.domain.todo.dto.request;

import com.project.todo.domain.member.domain.Member;
import com.project.todo.domain.todo.domain.Todo;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class CreateTodoRequest {

    private String title;
    private boolean isChecked;
    private LocalDateTime dueDate;

    public Todo toEntity(Member member) {
        return Todo.builder()
                .member(member)
                .title(title)
                .isChecked(isChecked)
                .dueDate(dueDate)
                .build();
    }

}
