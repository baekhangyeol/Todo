package com.project.todo.domain.follow.repository;

import com.project.todo.domain.follow.domain.Follow;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByFollowerIdAndFollowingId(Long followerId, Long followingId);

    @Query("SELECT m.nickname FROM Follow f " +
        "JOIN Member m ON f.followerId = m.id " +
        "WHERE f.followingId = :memberId AND f.isDeleted = false")
    List<String> findFollowerNicknamesByMemberId(@Param("memberId") Long memberId);

    @Query("SELECT m.nickname FROM Follow f " +
        "JOIN Member m ON f.followingId = m.id " +
        "WHERE f.followerId = :memberId AND f.isDeleted = false")
    List<String> findFollowingNicknamesByMemberId(@Param("memberId") Long memberId);
}
