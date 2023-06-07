package com.example.sevenStore.store;

import com.example.sevenStore.store.discount.FixDiscountPolicy;
import com.example.sevenStore.store.member.MemberService;
import com.example.sevenStore.store.member.MemberServiceImpl;
import com.example.sevenStore.store.member.MemoryMemberRepository;
import com.example.sevenStore.store.order.OrderService;
import com.example.sevenStore.store.order.OrderServiceImpl;

public class AppConfig {

    // 관심사의 분리를 통해 이제 나누자

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(),
                new FixDiscountPolicy());
    }
}
