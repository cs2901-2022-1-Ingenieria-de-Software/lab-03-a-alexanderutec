package lab.demand;

public class Tax {
    
    public double calculateTax(String country) {
        switch (country) {
            case "PE": return 0.18;
            case "BR": return 0.12;
            default: return 0.0;
        }
    }
}
