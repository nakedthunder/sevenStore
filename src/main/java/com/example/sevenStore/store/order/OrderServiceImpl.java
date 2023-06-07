package com.example.sevenStore.store.order;

import com.example.sevenStore.store.discount.DiscountPolicy;
import com.example.sevenStore.store.member.*;

public class OrderServiceImpl implements OrderService{

   /* < 해 맴 >
   *  createOrder
   *    - 주문 생성 요청이 오면, 회원 정보를 조회하고
   *    - 할인 정책을 적용한 다음 주문객체를 생성해서 반환한다.
   *    " 메모리 회원 리포지토리와, 고정 금액 할인 정책을 구현체로 생성한다. "
   * */

    // 인터페이스에만 의존하도록 변경 (기존에는 인터페이스, 구현체 둘다의존)
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // createOrder를 사용할꺼니깐, 그걸 내가사용할 수 있게 만들어줘야지

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, 1000);

        // Order생성자를 통해서 반환값 처리하면서 주문생성함
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
