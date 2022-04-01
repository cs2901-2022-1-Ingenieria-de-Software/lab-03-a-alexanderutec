package lab;

import lab.demand.ManageDemandCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lab.demand.ManageDemand;
import lab.demand.Tax;
import lab.util.TestUtil;
import lab.demand.Order;

import java.util.List;

@Test
public class ManageDemandTest {

    private Tax tax;

    private ManageDemand demand;
    private ManageDemandCalculator calculator;
    @BeforeClass
    public void setup() {
        tax = new Tax();
        demand =  new ManageDemand(tax);
        calculator = new ManageDemandCalculator();
    }
    
    public void test_AllOrdersFromPeru() {
        List<Order> ordersFromPeru = TestUtil.buildOrdersPeru();
//        double result = ManageDemandCalculator::calculateTotal(ordersFromPeru, tax);
        double result1 =calculator.calculateTotal(ordersFromPeru, tax);
        Assert.assertEquals(Math.round(result1), 7.0);
        List<Order> ordersFromColombia = TestUtil.buildOrdersColombia();
        double result2 =calculator.calculateTotal(ordersFromColombia, tax);
        Assert.assertEquals(Math.round(result2), 0.0);
    }

    public void testCalculateTotalForWithAdditionalByCountry() {
        List<Order> ordersFromPeru = TestUtil.buildOrdersColombia();
        double result = calculator.calculateTotalForWithAdditionalByCountry(ordersFromPeru, 0.13, 0.12, 0.03);
        System.out.println(result);
        Assert.assertEquals(result, 5.2);
    }

}
