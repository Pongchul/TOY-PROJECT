package com.FBLAB.backend.member.domain;

import com.FBLAB.backend.member.exception.MemberErrorCode;
import com.FBLAB.backend.member.exception.MemberException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.FBLAB.backend.member.exception.MemberErrorCode.*;
/*
 회원 아이디에서 처리해야 될 에러 조건들이 있을까 ?
 1. 회원 아이디 길이 조건 즉 최소 길이 최대 길이를 만족해야 한다.
 2. 이메일 포맷인 이메일 패턴이 들어간지 확인해야 한다.
 3. 회원 아이디는 빈칸이면 안된다.
 */
@Getter
@NoArgsConstructor
@Embeddable
public class UserId {

    private static final int MAXIMUM_LENGTH = 30;
    private static final int MINIMUM_LENGTH = 5;
    private static final String EMAIL_FORMAT = "@";

    @Column(name = "user_id", unique = true, length = 30)
    private String value;

    public UserId(String value) {
        this.value = value;
    }

    public static UserId from(String value) {
        validUserIdNotBlank(value);
        validUserIdOutOfRange(value);
        validUserIdIsNotEmailFormat(value);
        return new UserId(value);
    }


    public static void validUserIdNotBlank(String value) {
        if (value.isBlank()) {
            throw new MemberException(USER_ID_SHOULD_NOT_BE_BLANK);
        }
    }

    public static void validUserIdOutOfRange(String value) {
        if (value.length() > MAXIMUM_LENGTH || value.length() < MINIMUM_LENGTH) {
            throw new MemberException(USER_ID_CANNOT_BE_OUT_OF_RANGE);
        }
    }

    public static void validUserIdIsNotEmailFormat(String value) {
        if (!value.contains(EMAIL_FORMAT)) {
            throw new MemberException(USER_ID_SHOULD_BE_EMAIL_FORMAT);
        }
    }

}
