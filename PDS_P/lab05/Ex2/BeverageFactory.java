package Ex2;

public class BeverageFactory {
    static String fruit = "Orange";
    
    public static Portion create(Temperature temperature){
        if(temperature.equals(Temperature.COLD)){
            FruitJuice fruitJuice = new FruitJuice(fruit);
            return (Portion)fruitJuice;
        }
        else if(temperature.equals(Temperature.WARM)){
            Milk milk = new Milk();
            return (Portion)milk;
        }
        else{
            System.out.println("Temperatura inválida!");
            return null;
        }
    }
}
