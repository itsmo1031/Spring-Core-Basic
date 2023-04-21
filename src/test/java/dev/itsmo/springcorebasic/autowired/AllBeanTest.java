package dev.itsmo.springcorebasic.autowired;

import dev.itsmo.springcorebasic.AutoAppConfig;
import dev.itsmo.springcorebasic.discount.DiscountPolicy;
import dev.itsmo.springcorebasic.member.Grade;
import dev.itsmo.springcorebasic.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);

        int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");
        assertThat(rateDiscountPrice).isEqualTo(2000);
    }


    static class DiscountService {

        /* 참조링크
         * https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-autowired-annotation
         */

        private final Map<String, DiscountPolicy> policyMap;
        // Map<String, DiscountPolicy>과 같은 타입의 스프링 빈을 찾아 주입 (스프링에서 공식 지원)
        private final List<DiscountPolicy> policies;
        // value값만 필요할때 List로 받아올 수도 있음


        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);
        }
    }
}
