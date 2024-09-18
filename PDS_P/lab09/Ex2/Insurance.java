package lab09.Ex2;

import java.util.List;
import java.util.ArrayList;

public class Insurance {
    
    private List<Employee> employees = new ArrayList<>();

    public void regist(Employee e) {
        employees.add(e);
        System.out.println("Employee " + e.getName() + " registered in Insurance");
    }
}
