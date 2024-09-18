package lab10.Ex2_ChainOfResponsability;

public class SushiChef extends Chef {
    public void Chef(String pedido) {
		if(canHandle(pedido.toLowerCase(), "sushi")) {
			System.out.println("SushiChef: Starting to cook " +pedido+". Out in 14 minutes!");
		}
		
		else {
			System.out.println("SushiChef: I can't cook that.");
            super.Chef(pedido);
		}
	}
}
