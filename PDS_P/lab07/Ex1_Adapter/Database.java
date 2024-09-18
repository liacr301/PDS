package lab07.Ex1_Adapter;

import java.util.Vector;

public class Database {
    private Vector<Employee> employees; // Stores the employees
    
    public Database() {
        employees = new Vector<>();
    }

    public boolean addEmployee(Employee employee) {
        // Code to add employee
        if (employees.contains(employee) || employee ==null){
            return false;
        }
        else{
            employees.add(employee);
            return true;
        }
    }

    public void deleteEmployee(long emp_num) {
        // Code to delete employee
        for (int n = 0; n <employees.size(); n++){
            if (employees.get(n).getEmpNum() == emp_num) {
                employees.remove(n);
            }
        }
    }
    public Employee[] getAllEmployees() {
        // Code to retrieve collection
        Employee[] allEmployees = new Employee[employees.size()];

        for(int n = 0; n <employees.size(); n++){
            allEmployees[n] = employees.get(n);
        }

        return allEmployees;
    }
}
        

