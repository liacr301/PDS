package lab10.Ex2_ChainOfResponsability;

public class Chef {
    private Chef sucessor = null;
	
	public void Chef(String pedido) {
		if(sucessor != null) {
			sucessor.Chef(pedido);
		}
		
		else {
			System.out.println("We're sorry but that request can't be satisfied by our service!");
		}
	}
	
	protected boolean canHandle(String pedido, String tipo) {
		return (pedido == null) || (pedido.contains(tipo.toLowerCase()));
	}
	
	public Chef setSucessor(Chef sucessor) {
		this.sucessor = sucessor;
		return this;
	}
}
