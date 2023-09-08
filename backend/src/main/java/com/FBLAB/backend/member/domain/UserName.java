package com.FBLAB.backend.member.domain;

import com.FBLAB.backend.member.exception.MemberException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.FBLAB.backend.member.exception.MemberErrorCode.*;

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
        validUserNameIsNotBlank(value);
        validUserNameOutOfRange(value);
        return new UserName(value);
    }

    public UserName update(String value) {
        return UserName.from(value);
    }

    public static void validUserNameIsNotBlank(String value) {
        if (value.isBlank()) {
            throw new MemberException(USER_NAME_SHOULD_NOT_BE_BLANK);
        }
    }

    public static void validUserNameOutOfRange(String value) {
        if (value.length() > MAXIMUM_LENGTH || value.length() < MINIMUM_LENGTH) {
            throw new MemberException(USER_NAME_CANNOT_BE_OUT_OF_RANGE);
        }
    }
}
