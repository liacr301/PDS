package Decorator;

public class BasicCoffee implements Coffee{
    private String name;
    private String description;
    private double cost;

    public BasicCoffee(){
        this.name = "Basic Coffee";
        this.description = "This is a basic coffee";
        this.cost = 1.0;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public double getCost(){
        return this.cost;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

}
