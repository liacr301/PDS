package lab10.Ex2_ChainOfResponsability;

public class BurgerChef extends Chef {
    public void Chef(String pedido) {
		if(canHandle(pedido.toLowerCase(), "burger")) {
			System.out.println("BurgerChef: Starting to cook " +pedido+". Out in 19 minutes!");
		}
		
		else {
			System.out.println("BurgerChef: I can't cook that.");
            super.Chef(pedido);
		}
	}
}
