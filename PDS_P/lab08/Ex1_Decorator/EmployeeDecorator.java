package lab08.Ex1_Decorator;

import java.util.Date;

public class EmployeeDecorator implements EmployeeInterface{
    protected EmployeeInterface employee;

    public EmployeeDecorator(EmployeeInterface employee) {
        this.employee = employee;
    }

    @Override
    public void start(Date start){
        employee.start(start);
    }

    @Override
    public void end(Date end){
        employee.end(end);
    }

    @Override
    public void work(){
        employee.work();
    }

    @Override
	public String toString() {
		return employee.toString();
	}

}
