package lab08.Ex3_Composite;

public class Doce extends Produto{
    private String name;
    private double weight;

    public Doce (String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    public void draw(){
        System.out.println("Doce ' " + name+ "' - Weigth : "+ weight);
    }
}
