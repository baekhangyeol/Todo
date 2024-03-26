package com.project.todo.domain.follow.service;

import com.project.todo.domain.follow.domain.Follow;
import com.project.todo.domain.follow.repository.FollowRepository;
import com.project.todo.domain.member.domain.Member;
import com.project.todo.domain.member.repository.MemberRepository;
import com.project.todo.global.error.ErrorCode;
import com.project.todo.global.error.exception.NotFoundException;
import com.project.todo.global.error.exception.UnauthorizedAccessException;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class FollowService {
    private final FollowRepository followRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void addFollow(Long following, Member follower) {
        if(following.equals(follower.getId()))
            throw new UnauthorizedAccessException(ErrorCode.FOLLOW_SELF_ERROR);

        Optional<Follow> existedFollow = followRepository.findByFollowerIdAndFollowingId(follower.getId(), following);

        if(existedFollow.isPresent()) {
            Follow existFollow = existedFollow.get();
            if(existFollow.isDeleted())
                existFollow.restore();
        }
        else {
            Member followMember = memberRepository.findById(following)
                .orElseThrow(() -> new NotFoundException(ErrorCode.MEMBER_NOT_FOUND));
            Follow newFollow = new Follow(follower.getId(), followMember.getId());
            followRepository.save(newFollow);
        }
    }

    @Transactional
    public void deleteFollow(Long following, Member follower) {
        Follow follow = followRepository.findByFollowerIdAndFollowingId(follower.getId(), following)
                .orElseThrow(() -> new NotFoundException(ErrorCode.MEMBER_NOT_FOUND));
        follow.delete();
    }

    @Transactional
    public List<Long> findFollowers(Long memberId) {
        return followRepository.findFollowerIdsByMemberId(memberId);
    }
}
