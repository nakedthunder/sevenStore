package com.example.sevenStore.store.discount;

import com.example.sevenStore.store.member.Grade;
import com.example.sevenStore.store.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount; // 1000원 할인을 return
        }
        return 0; // 아니면 없음 (BASIC)
    }
}
