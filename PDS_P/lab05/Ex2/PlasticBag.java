package Ex2;

public class PlasticBag extends Container{
    Portion menu;

    public PlasticBag(Portion menu){
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
        return String.format("Plastic Bag with portion = %s", menu);
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
