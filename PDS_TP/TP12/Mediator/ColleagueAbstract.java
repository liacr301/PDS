package TP12.Mediator;

public abstract class ColleagueAbstract {
    protected ChatMediator mediator;

    public ColleagueAbstract(ChatMediator mediator) {
        this.mediator = mediator;
    }

    public abstract void sendMessage();
	
	public abstract void recieveMessage(String msg);

}
