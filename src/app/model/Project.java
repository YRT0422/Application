package app.model;

import java.util.ArrayList;

import java.io.Serializable;
public class Project implements Serializable {
    private String name;
    private int K_value;
    private ArrayList<Subproject> subprojects = new ArrayList<Subproject>();
    private ArrayList<Bidder> bidders = new ArrayList<Bidder>();
    private double expectedPrice = 0;
    private ArrayList<Bidder> topBidders = new ArrayList<Bidder>(3);
    public Project(String name){
        this.name = name;
    }
    public void addSubproject(String name,String unit, double amount, double expectedPrice){
        Subproject newSubproject = new Subproject(name, unit, amount, expectedPrice, K_value);
        subprojects.add(newSubproject);
        this.expectedPrice+=newSubproject.getExpectedPrice();
    }
    public void addBidder(String name, ArrayList<Double> priceList){
        Bidder newBidder = new Bidder(name, priceList);
        update(newBidder);
    }
    public void update(Bidder newBidder){
        bidders.add(newBidder);
        int numBidders = bidders.size();
        for(int i=0; i<subprojects.size(); i++){
            subprojects.get(i).setBiddersAvg
                    (((numBidders-1)*subprojects.get(i).getBiddersAvg()+newBidder.getPriceList().get(i))/numBidders);
            //update bidder's grade
        }
    }

    public String getName() {
        return name;
    }
}
