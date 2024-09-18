package Ex2;

public class FruitJuice extends PortionFactory implements Portion{
    private String fruit;

    public FruitJuice (String fruit){
        this.fruit = fruit;
    }

    public String getFruit(){
        return fruit;
    }

    public void setFruit(String fruit){
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return String.format("Fruit Juice: Temperature %s, State %s", getTemperature(), getState());
    }

    @Override 
    public Temperature getTemperature(){
        return Temperature.COLD;
    }

    @Override
    public State getState(){
        return State.Solid;
    } 
}
