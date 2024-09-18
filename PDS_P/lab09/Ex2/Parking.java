package lab09.Ex2;

import java.util.List;
import java.util.ArrayList;

public class Parking {
    
    private List<Employee> parkinList = new ArrayList<>();

    public boolean allow(Employee e, Company company) {
        if (e.getSalary() > company.averageSalary()) {
            parkinList.add(e);
            System.out.println("Employee " + e.getName() + " allowed to use parking");
            return true;
        } else {
            System.out.println("Employee " + e.getName() + " not allowed to use parking");
            return false;
        }
    }
}
