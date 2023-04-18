package dev.itsmo.springcorebasic;

import dev.itsmo.springcorebasic.member.Grade;
import dev.itsmo.springcorebasic.member.Member;
import dev.itsmo.springcorebasic.member.MemberService;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
