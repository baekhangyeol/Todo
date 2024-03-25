package com.project.todo.domain.follow.repository;

import com.project.todo.domain.follow.domain.Follow;
import com.project.todo.domain.member.domain.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByFollowerIdAndFollowingId(Long followerId, Long followingId);
}
