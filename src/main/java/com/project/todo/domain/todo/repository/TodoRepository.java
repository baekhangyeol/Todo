package com.project.todo.domain.todo.repository;

import com.project.todo.domain.todo.domain.Todo;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByDueDateAndMemberId(LocalDateTime dueDate, Long memberId);
}
