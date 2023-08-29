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
    @Column(name = "member_id")
    private Long memberId;

    private String memberName;
    private String NickName;

    @Embedded
    private UserId userId;

    @Embedded
    private UserName userName;
}
