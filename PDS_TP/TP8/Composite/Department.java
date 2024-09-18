package Composite;
import java.util.ArrayList;
import java.util.List;

public class Department implements Employee{
    private List<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employeeList.remove(employee);
    }

    @Override
    public void showEmployeeDetails() {
        for(Employee emp : employeeList) {
            emp.showEmployeeDetails();
        }
    }
}
