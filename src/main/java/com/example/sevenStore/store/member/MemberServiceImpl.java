package com.example.sevenStore.store.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class MemberServiceImpl implements MemberService{

    // @Autowired 어노테이션을 직접 적용하여 필드 주입을 수행
   @Autowired
    MemberRepository memberRepository;

    // 생성자 주입
//    private final MemberRepository memberRepository;
//
//    public MemberServiceImpl(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
