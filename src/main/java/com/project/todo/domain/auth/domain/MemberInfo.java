package com.project.todo.domain.auth.domain;

import com.project.todo.domain.member.domain.Member;
import java.util.List;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Getter
public class MemberInfo extends User {
    private Member member;

    public MemberInfo(Member member) {
        super(member.getEmail(), member.getPassword(), List.of(new SimpleGrantedAuthority("USER")));
        this.member = member;
    }
}
