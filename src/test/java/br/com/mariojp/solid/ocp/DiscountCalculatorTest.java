package br.com.mariojp.solid.ocp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EnumMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class DiscountCalculatorTest {

    @Test
    void partner_gets_12_percent() {
        Map<CustomerType, DiscountPolicy> policies = new EnumMap<>(CustomerType.class);
        policies.put(CustomerType.REGULAR, new RegularPolicy());
        policies.put(CustomerType.PREMIUM, new PremiumPolicy());
        policies.put(CustomerType.PARTNER, new PartnerPolicy());

        DiscountCalculator calc = new DiscountCalculator(policies);
        
        double discountedValue = calc.apply(100.0, CustomerType.PARTNER);

        assertEquals(88.0, discountedValue, "PARTNER deveria ter 12% de desconto");
    }
    
    }