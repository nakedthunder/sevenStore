package com.example.sevenStore.store;

import com.example.sevenStore.store.member.Grade;
import com.example.sevenStore.store.member.Member;
import com.example.sevenStore.store.member.MemberService;
import com.example.sevenStore.store.member.MemberServiceImpl;
import com.example.sevenStore.store.order.Order;
import com.example.sevenStore.store.order.OrderService;
import com.example.sevenStore.store.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

      /*  MemberService memberService = new MemberServiceImpl(memberRepository);
        OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);
*/
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        // given: 회원가입을 한다.
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // 주문을 생성한다.
        Order order = orderService.createOrder(member.getId(), "itemA", 10000);

        System.out.println("주문 = " + order);
    }
}
