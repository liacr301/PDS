package lab08.Ex1_Decorator;

import java.util.Date;

public class TeamMember extends EmployeeDecorator{
    
    TeamMember(EmployeeInterface employee){
        super(employee);
    }

    @Override
    public void start(Date start){
        System.out.println(super.toString() + "\nTeam Member number started working on " + start + "\n");
    }

    @Override
    public void end(Date end){
        System.out.println(super.toString() + "\nTeam Member number stopped working on " + end + "\n");
    }

    @Override
    public void work(){
        System.out.println(super.toString() + "\nTeam Member is working" + "\n");
    }

    public void colaborate(){
        System.out.println(super.toString() + "\nTeam Member is colaborating" + "\n");
    }
}
