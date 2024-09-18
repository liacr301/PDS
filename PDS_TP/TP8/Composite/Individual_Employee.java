package Composite;
public class Individual_Employee implements Employee{
    private String name;
    private String position;
    
    public Individual_Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }
    
    @Override
    public void showEmployeeDetails() {
        System.out.println("Employee: [ Name: " + name + ", ID: " + position + " ]");
    }
}
