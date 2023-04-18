package dev.itsmo.springcorebasic;

import dev.itsmo.springcorebasic.member.Grade;
import dev.itsmo.springcorebasic.member.Member;
import dev.itsmo.springcorebasic.member.MemberService;
import dev.itsmo.springcorebasic.member.MemberServiceImpl;
import dev.itsmo.springcorebasic.order.Order;
import dev.itsmo.springcorebasic.order.OrderService;
import dev.itsmo.springcorebasic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
