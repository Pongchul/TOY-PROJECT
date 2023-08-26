package com.FBLAB.backend.member.exception;

import com.FBLAB.backend.global.exception.CustomException;

public class MemberException extends CustomException {

    public MemberException(MemberErrorCode code) {
        super(code);
    }
}
