package com.project.todo.domain.member.service;

import com.project.todo.domain.member.domain.Member;
import com.project.todo.domain.member.repository.MemberRepository;
import com.project.todo.global.error.ErrorCode;
import com.project.todo.global.error.exception.EmptyResultDataException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public void checkEmailDuplication(String email) {
        if(memberRepository.findByEmail(email).isPresent())
            throw new EmptyResultDataException(ErrorCode.EMAIL_DUPLICATE_ERROR);
    }

    public void addMember(Member member) {
        memberRepository.save(member);
    }
}
