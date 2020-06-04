package app.model;
import java.util.ArrayList;
public class Bidder {
    private String name;
    private ArrayList<Double> priceList;
    public Bidder (String name, ArrayList<Double> priceList ){
        this.name = name;
        this.priceList = priceList;
    }

    public ArrayList<Double> getPriceList() {
        return priceList;
    }
}
