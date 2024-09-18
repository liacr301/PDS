package lab08.Ex1_Decorator;

import java.util.Date;

public class TeamLeader extends EmployeeDecorator {

    TeamLeader(EmployeeInterface employee){
        super(employee);
    }

    @Override
    public void start(Date start){
        System.out.println(super.toString() + "\nTeam Leader number started working on " + start + "\n");
    }

    @Override
    public void end(Date end){
        System.out.println(super.toString() + "\nTeam Leader number stopped working on " + end + "\n");
    }

    @Override
    public void work(){
        System.out.println(super.toString() + "\nTeam Leader is working" + "\n");
    }

    public void plan(){
        System.out.println(super.toString() + "\nTeam Leader is planning" + "\n");
    }
    
}
