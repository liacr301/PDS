package lab08.Ex1_Decorator;

import java.util.Date;

public class Employee implements EmployeeInterface{
    private String name;
    private int num_emp;

    Employee(String name, int num_emp){
        this.name = name;
        this.num_emp = num_emp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum_emp() {
        return num_emp;
    }

    public void setNum_emp(int num_emp) {
        this.num_emp = num_emp;
    }

    public void start(Date start){
        System.out.println("Employee number " + num_emp + " started working on " + start);
    }

    public void end(Date end){
        System.out.println("Employee number " + num_emp + " stopped working on " + end);
    }

    public void work(){
        System.out.println("Employee number " + num_emp + " is working");
    }

    @Override
    public String toString() {
        return "Employee:\nName: " + name + "; Number: "+ num_emp;
    }
}
