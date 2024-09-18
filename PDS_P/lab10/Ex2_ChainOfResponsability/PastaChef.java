package lab10.Ex2_ChainOfResponsability;

public class PastaChef extends Chef {
    public void Chef(String pedido) {
		if(canHandle(pedido.toLowerCase(), "pasta")) {
			System.out.println("PastaChef: Starting to cook " +pedido+". Out in 14 minutes!");
		}
		
		else {
			System.out.println("PastaChef: I can't cook that.");
            super.Chef(pedido);
		}
	}
}
