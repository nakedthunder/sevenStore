package com.example.sevenStore.store;

import com.example.sevenStore.store.discount.DiscountPolicy;
import com.example.sevenStore.store.discount.FixDiscountPolicy;
import com.example.sevenStore.store.discount.RateDiscountPolicy;
import com.example.sevenStore.store.member.MemberRepository;
import com.example.sevenStore.store.member.MemberService;
import com.example.sevenStore.store.member.MemberServiceImpl;
import com.example.sevenStore.store.member.MemoryMemberRepository;
import com.example.sevenStore.store.order.OrderService;
import com.example.sevenStore.store.order.OrderServiceImpl;

public class AppConfig {

    // 관심사의 분리를 통해 이제 나누자

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(),
                discountPolicy());
    }

    /*
    * 리팩토링을 추가
    * - new 해서 MemoryMemberRepository 구현체를 부르지않아도 된다.
    * */
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // 정액할인 -> 정률할인으로 변경 (구성영역만 영향을 받음, 사용영역 OrderServiceImpl 은 안받음)
    public DiscountPolicy discountPolicy() {
       // 정약할인 return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
