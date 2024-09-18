package lab08.Ex3_Composite;

public class Bebida extends Produto{

    private String name;
    private double weight;

    public Bebida (String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    public void draw(){
        System.out.println("Bebida ' " + name+ "' - Weigth : "+ weight);
    }
}
@startuml

interface ItemInterface {
    {abstract} + draw(): void
    {abstract} + getWeight(): double
}

class Caixa {
    - name: String
    - weight: double
    - items: ArrayList<ItemInterface>
    + Caixa(name: String, weight: double)
    + add(item: ItemInterface): void
    + draw(): void
    + getWeight(): double
}

class Produto {
    - name: String
    - weight: double
    + Produto(name: String, weight: double)
    + draw(): void
    + getWeight(): double
}

class Bebida {
    - name: String
    - weight: double
    + Bebida(name: String, weight: double)
    + draw(): void
    + getWeight(): double
}

class Conserva {
    - name: String
    - weight: double
    + Conserva(name: String, weight: double)
    + draw(): void
    + getWeight(): double
}

class Doce {
    - name: String
    - weight: double
    + Doce(name: String, weight: double)
    + draw(): void
    + getWeight(): double
}

Produto <|-- Bebida
Produto <|-- Conserva
Produto <|-- Doce

ItemInterface <|-- Caixa
ItemInterface <|-- Produto

@enduml
