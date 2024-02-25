package com.FBLAB.backend.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUserIdAndPassword(UserId userId, Password password);

    Optional<Member> findByUserId(UserId userId);


}
