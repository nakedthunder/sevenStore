package com.example.sevenStore.store.order;

import com.example.sevenStore.store.AppConfig;
import com.example.sevenStore.store.member.Grade;
import com.example.sevenStore.store.member.Member;
import com.example.sevenStore.store.member.MemberService;
import com.example.sevenStore.store.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

   /* MemberService memberService = new MemberServiceImpl(memberRepository);
    OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);
*/
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA" , Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}