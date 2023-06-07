package com.example.sevenStore.store.member;

import com.example.sevenStore.store.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    //MemberService memberService = new MemberServiceImpl(memberRepository);

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member); // 등록하고
        Member findMember = memberService.findMember(1L);


        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}