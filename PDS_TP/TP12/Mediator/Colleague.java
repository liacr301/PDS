package TP12.Mediator;

public class Colleague extends ColleagueAbstract{

    public Colleague(ChatMediator med) {
		super(med);
	}

	@Override
	public void sendMessage(){
		System.out.println("Sending Message: HELLO!!");
		mediator.sendMessage();
	}
	@Override
	public void recieveMessage(String msg) {
		System.out.println("Received Message:"+msg);
	}
}
