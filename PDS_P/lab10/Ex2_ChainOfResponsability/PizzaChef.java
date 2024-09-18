package lab10.Ex2_ChainOfResponsability;

public class PizzaChef extends Chef {
    public void Chef(String pedido) {
		if(canHandle(pedido.toLowerCase(), "pizza")) {
			System.out.println("PizzaChef: Starting to cook " +pedido+". Out in 7 minutes!");
		}
		
		else {
			System.out.println("PizzaChef: I can't cook that.");
            super.Chef(pedido);
		}
	}
}
