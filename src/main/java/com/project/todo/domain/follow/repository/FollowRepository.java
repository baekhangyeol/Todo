package com.project.todo.domain.follow.repository;

import com.project.todo.domain.follow.domain.Follow;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByFollowerIdAndFollowingId(Long followerId, Long followingId);

    @Query("SELECT f.followerId FROM Follow f WHERE f.followingId = :memberId AND f.isDeleted = false")
    List<Long> findFollowerIdsByMemberId(Long memberId);
}
