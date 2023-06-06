package com.example.sevenStore.store.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
