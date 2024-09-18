package lab10.Ex2_ChainOfResponsability;

public class DessertChef extends Chef {
    public void Chef(String pedido) {
		if(canHandle(pedido.toLowerCase(), "dessert")) {
			System.out.println("DessertChef: Starting to cook " +pedido+". Out in 17 minutes!");
		}
		
		else {
			System.out.println("DessertChef: I can't cook that.");
            super.Chef(pedido);
		}
	}
}
