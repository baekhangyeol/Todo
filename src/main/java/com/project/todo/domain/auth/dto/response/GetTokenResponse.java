package com.project.todo.domain.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class GetTokenResponse {
    private String grantType;
    private String accessToken;
    private String refreshToken;
}
