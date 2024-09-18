package Ex2;

public class PlasticBottle extends Container{
    Portion menu;

    public PlasticBottle(Portion menu){
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
        return String.format("PlasticBottle with portion = %s", menu);
    }

    @Override
    public Temperature getTemperature(){
        return Temperature.COLD;
    }

    @Override
    public State getState(){
        return State.Liquid;
    }
}
