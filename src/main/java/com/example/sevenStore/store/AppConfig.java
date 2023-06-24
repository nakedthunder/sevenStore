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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    /*< 필드주입 >
    * return 값으로 new MemberServiceImpl()을 호출하여
    * MemberServiceImpl 인스터스를 생성하고 스프링은 @Autowired 를 통해
    * memberRepository를 주입한다.
    * - @Bean, @Autowried를 지우면 memberService에 대한 NoSuchBean 오류생성
    *
    * <NoSuchBean>
    * 스프링 컨테이너에 MemberService를 등록하지 않았기 때문, 필드주입을 사용할 경우
    * 해당 빈을 스프링컨테이너에 적용해야함
    *
    * <Bean>
    * meberService() 메서드를 빈으로 등록하고 있다. 스프링 컨테이너가 MemberService
    * 의 인스턴스를 생성하고 필요한 의존성을 주입할 수 있게 된다. 스프링 컨테이너가 빈을
    * 인식하고 관리할 수 있도록 'bean' 어노테이션을 통해 해당 빈을 등록한다.
    *
    * <@Configuration>
    * AppConfig 클래스를 스프링의 설정 클래스로 지정해야함
     * */
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl();
    }

    // 생성자 주입
//    @Bean
//    public MemberService memberService() {
//        return new MemberServiceImpl(memberRepository());
//    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(),
                discountPolicy());
    }

    /*
    * 리팩토링을 추가
    * - new 해서 MemoryMemberRepository 구현체를 부르지않아도 된다.
    * */
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // 정액할인 -> 정률할인으로 변경 (구성영역만 영향을 받음, 사용영역 OrderServiceImpl 은 안받음)
    @Bean
    public DiscountPolicy discountPolicy() {
       // 정약할인 return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
