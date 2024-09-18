package TP12.Mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediator implements Mediator {

    private List<ColleagueAbstract> users;
    
    public ChatMediator() {
        this.users = new ArrayList<>();
    }
    
    @Override
    public void addColleague(ColleagueAbstract colleague) {
        this.users.add(colleague);
    }
    
    @Override
    public void sendMessage() {
        for (ColleagueAbstract user : this.users) {
        	user.recieveMessage("Recieved!");
        }
    }
}
