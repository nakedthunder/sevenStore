package com.example.sevenStore.store.member;

public class Member {

    // 변수에 private
    private Long id;
    private String  name;
    private Grade grade;


    // 기본적으로 클래스에 생성자를 하나 생성해주니 적어보지 않겠음
    // 머지 MemberApp에서 테스트겸 해봤는데 생성자 없다고 선언하라고 알림뜸
    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
