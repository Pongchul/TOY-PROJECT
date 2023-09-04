package com.FBLAB.backend.member.domain;

import com.FBLAB.backend.member.exception.MemberErrorCode;
import com.FBLAB.backend.member.exception.MemberException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.regex.Pattern;

@Getter
@Embeddable
@NoArgsConstructor
public class Password {

    /**
     * 1. 비밀번호 패턴은 최소 8 자, 하나 이상의 대문자, 하나의 소문자, 하나의 숫자 및 하나의 특수 문자를 포함 해야 한다.
     * 2. 비밀번호 암호화
     * 3. 비밀번호 업데이터
     * 4. 비밀번호 검증 (패턴에 맞는지? 이전 비밀번호와 같은지?)
     */
    private static final String PASSWORD_FORMAT = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_FORMAT);

    @Column(name = "password")
    private String value;

    public Password(String value) {
        this.value = value;
    }

    public static Password encrypt(String value, BCryptPasswordEncoder encoder) {
        validatePatternIsValid(value);
        return new Password(encoder.encode(value));
    }

    public boolean isSame(String password) {
        return value.equals(password);
    }

    public Password update(String value, BCryptPasswordEncoder encoder) {
        return Password.encrypt(value, encoder);
    }

    private static boolean isNotValid(String password) {
        return !PASSWORD_PATTERN.matcher(password).matches();
    }

    private static void validatePatternIsValid(String value) {
        if (isNotValid(value)) {
            throw new MemberException(MemberErrorCode.PASSWORD_PATTERN_MUST_BE_VALID);
        }
    }

}
