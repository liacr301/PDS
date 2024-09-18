package Ex2;

public class MeatFactory {
    public static Portion create(Temperature temperature){

        if(temperature.equals(Temperature.COLD)){
            Tuna tuna = new Tuna();
            return (Portion)tuna;
        }
        else if(temperature.equals(Temperature.WARM)){
            Pork pork = new Pork();
            return (Portion)pork;
        }

        else{
            System.out.println("Temperatura inválida!");
            return null;
        }
    }    
}
