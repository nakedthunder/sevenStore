package com.example.sevenStore.store.member;

public class MemberServiceImpl implements MemberService{

    // 아 내 코드는 의존관게 주입을 해준거고 이거는 일단 OCP 위반으로
    // impl()을 호출해서 코드작성
   private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
