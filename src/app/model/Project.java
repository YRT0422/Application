package app.model;

import java.util.ArrayList;

public class Project {
    public String name;
    public int K_value;
    public ArrayList<Subproject> subprojects = new ArrayList<Subproject>();
    public double expectedPrice;
    public Project(String name, int K_value){
        this.name = name;
        this.K_value = K_value;
    }
    public void addSubproject(String name,String unit, double amount, double expectedPrice){
        Subproject newSubproject = new Subproject(name, unit, amount, expectedPrice, K_value);
        subprojects.add(newSubproject);
    }
    public void addBidder(String name){

    }

}
