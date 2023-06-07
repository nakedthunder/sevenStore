package com.example.sevenStore.store;

import com.example.sevenStore.store.member.Grade;
import com.example.sevenStore.store.member.Member;
import com.example.sevenStore.store.member.MemberService;
import com.example.sevenStore.store.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MemberApp {
    public static void main(String[] args) {
        // AppConfig를 통해 생성자 주입으로 변경
        //1) 변경: MemberService memberService = new MemberServiceImpl(memberRepository);

        /*
        * 2) 변경
        *   AppConfig appConfig = new AppConfig();
        *   MemberService memberService = appConfig.memberService();
        * */

        // 3) 스프링 컨테이너 적용 
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
