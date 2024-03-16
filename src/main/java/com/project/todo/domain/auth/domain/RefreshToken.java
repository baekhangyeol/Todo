package com.project.todo.domain.auth.domain;

import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;
import org.springframework.security.core.GrantedAuthority;

@RedisHash(value = "RE")
@Getter
@Builder
@AllArgsConstructor
public class RefreshToken {
    @Id
    private String token;

    @Indexed
    private String email;

    @TimeToLive
    @Builder.Default
    private Long expiration = 7L * 24L * 60L * 60L;

    public Collection<? extends GrantedAuthority> authorities;
}
