package Ex2;

public abstract class Container implements Portion {
    public static Container create(Portion menu){
        if (menu == null)
            return null;

        Container[] containers = new Container[] {new PlasticBottle(menu), new TermicBottle(menu), new Tupperware(menu), new PlasticBag(menu)};
        for (Container container: containers){
            if(menu.getTemperature().equals(container.getTemperature()) && (menu.getState().equals(container.getState())))
                return container;
        }

        return null;
    }
}
