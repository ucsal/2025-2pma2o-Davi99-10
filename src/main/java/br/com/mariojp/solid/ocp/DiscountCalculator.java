package br.com.mariojp.solid.ocp;

import br.com.mariojp.solid.ocp.CustomerType;   
import br.com.mariojp.solid.ocp.DiscountPolicy; 
import java.util.Map;
import java.util.Optional;


public class DiscountCalculator {
	
private final Map<CustomerType, DiscountPolicy> policies;

    public DiscountCalculator(Map<CustomerType, DiscountPolicy> policies) {
        this.policies = policies;
    }

    public double apply(double amount, CustomerType type) {
        DiscountPolicy policy = policies.get(type);
        if (policy != null) {
            return policy.apply(amount);
        }     
        return amount;
    }
}

