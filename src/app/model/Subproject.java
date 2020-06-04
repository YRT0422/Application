package app.model;

public class Subproject {
    private String name;
    private String unit;
    private double amount;
    private double expectedPrice;
    private double sum;
    private double K_value;
    private double expectedPriceFloatedDown;
    private double biddersAvg;
    private double standardPrice;
    public Subproject(String name,String unit, double amount, double expectedPrice, double K_value) {
        this.name = name;
        this.unit = unit;
        this.amount = amount;
        this.expectedPrice = expectedPrice;
        this.sum = amount*expectedPrice;
        this.expectedPriceFloatedDown = expectedPrice*(1-K_value);
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getAmount() {
        return amount;
    }

    public double getExpectedPrice() {
        return expectedPrice;
    }

    public double getSum() {
        return sum;
    }

    public void setK_value(double k_value) {
        this.K_value = k_value;
    }

    public void setBiddersAvg(double biddersAvg) {
        this.biddersAvg = biddersAvg;
        standardPrice = (biddersAvg+expectedPriceFloatedDown)/2;
    }

    public double getBiddersAvg() {
        return biddersAvg;
    }

    public double getStandardPrice() {
        return standardPrice;
    }
}
