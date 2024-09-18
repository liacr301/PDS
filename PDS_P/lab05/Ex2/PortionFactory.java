package Ex2;

public class PortionFactory {
    public static Portion create(String type_food, Temperature temperature){
        if( type_food.equals("Meat")){

            return MeatFactory.create(temperature);
        }
        else if(type_food.equals("Beverage")){
            
            return BeverageFactory.create(temperature);
        }
        else{
            System.out.println("Tipo de comida inválida!");
            return null;
        }
    }
}
