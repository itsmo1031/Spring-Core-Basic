package dev.itsmo.springcorebasic.discount;

import dev.itsmo.springcorebasic.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
