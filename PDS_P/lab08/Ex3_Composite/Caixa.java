package lab08.Ex3_Composite;

import java.util.ArrayList;

public class Caixa implements ItemInterface{
    private String name;
    private double weight;
    private final ArrayList<ItemInterface> items = new ArrayList<ItemInterface>();

    public Caixa (String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public void add(ItemInterface item){
        items.add(item);
    }

    public void draw(){
        System.out.println("* Caixa " + "'" + name + "'" + " [ Weight: " + getWeight() + " ; Total : " + getWeight() + "]");
        for (ItemInterface c : items) {
            c.draw();            
        }
    }

    public double getWeight(){
        double totalWeight = weight; 
        for (ItemInterface item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
}
