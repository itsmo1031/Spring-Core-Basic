package dev.itsmo.springcorebasic.order;

import dev.itsmo.springcorebasic.discount.DiscountPolicy;
import dev.itsmo.springcorebasic.discount.FixDiscountPolicy;
import dev.itsmo.springcorebasic.member.Member;
import dev.itsmo.springcorebasic.member.MemberRepository;
import dev.itsmo.springcorebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
