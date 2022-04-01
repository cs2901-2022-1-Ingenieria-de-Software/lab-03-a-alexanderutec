package lab;

import lab.demand.Tax;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TaxTest {
    private Tax tax;
    @BeforeClass
    public void setUp() {
        tax = new Tax();
    }

    @Test
    public void testCalculateTax() {
        Assert.assertEquals(tax.calculateTax("PE"), 0.18);
        Assert.assertEquals(tax.calculateTax("BR"), 0.12);
        Assert.assertEquals(tax.calculateTax("FR"), 0.0);
    }
}
