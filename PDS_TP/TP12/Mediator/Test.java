package TP12.Mediator;

public class Test {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediator();
        Colleague c1 = new Colleague(mediator);
        ColleagueAbstract c2 = new Colleague(mediator);
        mediator.addColleague(c1);
        mediator.addColleague(c2);
        c1.sendMessage();
        c2.sendMessage();
        c1.sendMessage();
        c2.sendMessage();
    }
}
