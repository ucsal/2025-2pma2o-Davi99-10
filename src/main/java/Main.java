import br.com.mariojp.solid.ocp.*;
import java.util.EnumMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
    	
        Map<CustomerType, DiscountPolicy> policies = new EnumMap<>(CustomerType.class);
        policies.put(CustomerType.REGULAR, new RegularPolicy());
        policies.put(CustomerType.PREMIUM, new PremiumPolicy());
        policies.put(CustomerType.PARTNER, new PartnerPolicy());

        DiscountCalculator calc = new DiscountCalculator(policies);

        System.out.println("REGULAR 100 -> " + calc.apply(100, CustomerType.REGULAR));
        System.out.println("PREMIUM 100 -> " + calc.apply(100, CustomerType.PREMIUM));
        System.out.println("PARTNER 100 -> " + calc.apply(100, CustomerType.PARTNER));
    }
}