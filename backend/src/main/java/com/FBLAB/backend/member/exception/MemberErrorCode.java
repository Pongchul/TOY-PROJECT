package com.FBLAB.backend.member.exception;

import com.FBLAB.backend.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;

public enum MemberErrorCode implements ErrorCode {

    USER_ID_SHOULD_NOT_BE_BLANK(400, "MEMBER_01", "사용자의 아이디가 공백입니다."),
    USER_ID_CANNOT_BE_OUT_OF_RANGE(400, "MEMBER_02", "사용자 아이디는 5자 이상 30자 이하입니다."),
    USER_ID_SHOULD_BE_EMAIL_FORMAT(400, "MEMBER_011", "사용자 아이디가 이메일 형식이 아닙니다."),
    ;

    private final int statusCode;
    private final String errorCode;
    private final String message;


    MemberErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
