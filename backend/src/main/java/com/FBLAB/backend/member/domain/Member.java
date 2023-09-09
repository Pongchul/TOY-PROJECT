package com.FBLAB.backend.member.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private UserId userId;

    @Embedded
    private UserName userName;

    @Embedded
    private Password password;

    public Member(UserId userId, UserName userName, Password password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }


}
