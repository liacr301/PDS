package lab08.Ex3_Composite;

public class Conserva extends Produto{ 
    private String name;
    private double weight;

    public Conserva (String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    public void draw(){
        System.out.println("Conserva ' " + name+ "' - Weigth : "+ weight);
    }
}
