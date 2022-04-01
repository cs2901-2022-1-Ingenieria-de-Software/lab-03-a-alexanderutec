package lab.demand;

import java.util.List;

public class ManageDemandCalculator {
    public double calculateCurrentTotal(List<Order> orders) {
        // Calculate Total
        double quantities = 0.0;
        for (Order order : orders) {
            double temp = order.getQuantity();
            quantities += temp;
        }
        return quantities;
    }
    public double calculateTotal(List<Order> orders, Tax taxObj) {
        // Calculate Taxes
        double taxes = 0.0;
        for (Order order : orders) {
            double tax = taxObj.calculateTax(order.getCountry());
            taxes += tax;
        }
        double quantities = calculateCurrentTotal(orders);
        return quantities * taxes;
    }

    public double calculateTotalForWithAdditionalByCountry(List<Order> orders, double defaultAdditionalColombia, double defaultAdditionalPeru, double defaultAdditionalBrazil) {
        // Calculate additionals by country
        double taxes = 0.0;
        for (Order order : orders) {
            String currCountry = order.getCountry();
            switch (currCountry) {
                case "PE":
                    taxes += defaultAdditionalPeru;
                case "BR":
                    taxes += defaultAdditionalBrazil;
                default:
                    taxes += defaultAdditionalColombia;
            }
        }
        // Calculate Total
        double quantities = calculateCurrentTotal(orders);
        return quantities * taxes;
    }
}
