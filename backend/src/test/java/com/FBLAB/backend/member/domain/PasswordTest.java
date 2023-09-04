package com.FBLAB.backend.member.domain;


import com.FBLAB.backend.member.exception.MemberException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class PasswordTest {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @DisplayName("올바른 비밀번호 패턴인가 ?")
    @ParameterizedTest
    @ValueSource(strings = {" ", "1234567!", "asdfghj!", "asdf1234", "12345678", "asdfghjk", "!@#$%^&*", "a1!"})
    void isThisTheRightPassword(String password) {
        Assertions.assertThatThrownBy(() -> Password.encrypt(password, encoder))
                .isInstanceOf(MemberException.class)
                .hasMessage("올바르지 않는 비밀번호 패턴 입니다.");
    }

}