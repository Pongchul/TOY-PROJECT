package com.FBLAB.backend.member.service.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    @NotNull
    private String userId;

    @NotNull
    private String password;

    @NotNull
    private String userName;

}
