package Ex2;

public class TermicBottle extends Container{
    Portion menu;

    public TermicBottle(Portion menu){
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
        return String.format("Termic Bottle with portion = %s", menu);
    }

    @Override
    public Temperature getTemperature(){
        return Temperature.WARM;
    }

    @Override
    public State getState(){
        return State.Liquid;
    }
}
