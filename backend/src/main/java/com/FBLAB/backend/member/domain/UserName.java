package com.FBLAB.backend.member.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Embeddable
public class UserName {

    private static final int MINIMUM_LENGTH = 1;
    private static final int MAXIMUM_LENGTH = 20;

    @Column(name = "name", length = 20)
    private String value;

    public UserName(String value) {
        this.value = value;
    }

    public static UserName from(String value) {
        return new UserName(value);
    }
}
