package dev.itsmo.springcorebasic;

import dev.itsmo.springcorebasic.discount.DiscountPolicy;
import dev.itsmo.springcorebasic.discount.RateDiscountPolicy;
import dev.itsmo.springcorebasic.member.MemberRepository;
import dev.itsmo.springcorebasic.member.MemberService;
import dev.itsmo.springcorebasic.member.MemberServiceImpl;
import dev.itsmo.springcorebasic.member.MemoryMemberRepository;
import dev.itsmo.springcorebasic.order.OrderService;
import dev.itsmo.springcorebasic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
