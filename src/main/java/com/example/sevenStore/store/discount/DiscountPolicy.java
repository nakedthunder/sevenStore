package com.example.sevenStore.store.discount;

import com.example.sevenStore.store.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
