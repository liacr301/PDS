package lab09.Ex2;

import java.util.ArrayList;
import java.util.List;

public class SocialSecurity {
    
    private List<Employee> employees = new ArrayList<>();
    
    public void regist(Employee e) {
        employees.add(e);
        System.out.println("Employee " + e.getName() + " registered in Social Security");
    }

}
