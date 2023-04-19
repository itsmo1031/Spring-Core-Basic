package dev.itsmo.springcorebasic;

import dev.itsmo.springcorebasic.discount.DiscountPolicy;
import dev.itsmo.springcorebasic.discount.RateDiscountPolicy;
import dev.itsmo.springcorebasic.member.MemberRepository;
import dev.itsmo.springcorebasic.member.MemberService;
import dev.itsmo.springcorebasic.member.MemberServiceImpl;
import dev.itsmo.springcorebasic.member.MemoryMemberRepository;
import dev.itsmo.springcorebasic.order.OrderService;
import dev.itsmo.springcorebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
