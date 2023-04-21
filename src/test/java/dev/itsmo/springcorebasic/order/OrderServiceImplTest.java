package dev.itsmo.springcorebasic.order;

import dev.itsmo.springcorebasic.discount.FixDiscountPolicy;
import dev.itsmo.springcorebasic.member.Grade;
import dev.itsmo.springcorebasic.member.Member;
import dev.itsmo.springcorebasic.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}