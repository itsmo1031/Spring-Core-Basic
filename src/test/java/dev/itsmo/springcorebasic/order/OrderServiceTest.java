package dev.itsmo.springcorebasic.order;

import dev.itsmo.springcorebasic.member.Grade;
import dev.itsmo.springcorebasic.member.Member;
import dev.itsmo.springcorebasic.member.MemberService;
import dev.itsmo.springcorebasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
