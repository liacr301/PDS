package Composite;
public class Company {
    public static void main(String[] args) {
        Employee emp1 = new Individual_Employee("John Doe", "1");
        Employee emp2 = new Individual_Employee("Jane Doe", "2");

        Department salesDepartment = new Department();
        salesDepartment.addEmployee(emp1);

        Department marketingDepartment = new Sub_Department();
        marketingDepartment.addEmployee(emp2);

        Department headDepartment = new Department();
        headDepartment.addEmployee(salesDepartment);
        headDepartment.addEmployee(marketingDepartment);

        headDepartment.showEmployeeDetails();
    }
}
