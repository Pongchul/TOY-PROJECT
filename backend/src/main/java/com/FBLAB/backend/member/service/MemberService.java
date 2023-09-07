package com.FBLAB.backend.member.service;

import com.FBLAB.backend.member.domain.*;
import com.FBLAB.backend.member.service.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final BCryptPasswordEncoder encoder;
    private final MemberRepository memberRepository;




    @Transactional
    public Long signUp(SignUpRequest request) {
        UserId userId = UserId.from(request.getUserId());
        UserName userName = UserName.from(request.getUserName());
        Password password = Password.encrypt(request.getPassword(), encoder);

        Member member = new Member(userId, userName, password);
        Member saveMemberId = memberRepository.save(member);

        return saveMemberId.getId();
    }
}
