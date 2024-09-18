package lab09.Ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Company {
    public static User user;
    private List<Employee> emps = new ArrayList<>(); 
    public void admitEmployee(String name, double salary){ 
        Employee e = new Employee(name, Double.valueOf(salary)); 
        emps.add(e);
    } 
    public void paySalaries(int month){
        for(Employee e : emps ){ 
            BankAccount ba = e.getBankAccount(); 
            ba.deposit(e.getSalary());
        } 
    } 
    public List<Employee> employees(){ 
        return Collections.unmodifiableList(emps); 
    }

    public double averageSalary() {
        double sum = 0;
        for (Employee e : emps) {
            sum += e.getSalary();
        }
        return sum / emps.size();
    }

}
    