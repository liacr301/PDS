package lab09.Ex2;

import java.util.List;

public class SharkCompany2 {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("Maria Silva"),
                new Person("Manuel Pereira"),
                new Person("Aurora Machado"),
                new Person("Augusto Lima")
        };

        Facade facadeComp = new Facade();
        Company shark = facadeComp.getCompany();
        Company.user = User.COMPANY;

        facadeComp.admitEmployee(persons[0].getName(), 1000);
        facadeComp.admitEmployee(persons[1].getName(), 900);
        facadeComp.admitEmployee(persons[3].getName(), 1100);
        facadeComp.admitEmployee(persons[2].getName(), 1200);
        List<Employee> sharkEmps = shark.employees();

        for (Employee e : sharkEmps)
            System.out.println(e.getSalary());
        shark.paySalaries(1);
    }
}