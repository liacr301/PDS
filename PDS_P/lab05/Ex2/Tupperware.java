package Ex2;

public class Tupperware extends Container{
    Portion menu;

    public Tupperware(Portion menu){
        this.menu = menu;
    }

    public Portion getPortion(){
        return menu;
    }

    public void setPortion(Portion menu){
        this.menu = menu;
    }

    @Override
    public String toString() {
        return String.format("Tupperware with portion = %s", menu);
    }

    @Override
    public Temperature getTemperature(){
        return Temperature.WARM;
    }

    @Override
    public State getState(){
        return State.Solid;
    }
}
