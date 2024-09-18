package lab08.Ex1_Decorator;

import java.util.Date;

public class Manager extends EmployeeDecorator{
    
    Manager(EmployeeInterface employee){
        super(employee);
    }

    @Override
    public void start(Date start){
        System.out.println(super.toString() + "\nManager started working on " + start + "\n");
    }

    @Override
    public void end(Date end){
        System.out.println(super.toString() + "\nManager stopped working on " + end + "\n");
    }

    @Override
    public void work(){
        System.out.println(super.toString() + "\nManager is working" + "\n");
    }

    public void manage(){
        System.out.println(super.toString() + "\nManager is managing" + "\n");
    }
}
