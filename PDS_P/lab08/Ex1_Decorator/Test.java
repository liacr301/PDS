package lab08.Ex1_Decorator;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        EmployeeInterface e1 = new Employee("João", 1);
        e1.start(new Date());
        e1.work();
        e1.end(new Date());

        TeamLeader TL1 = new TeamLeader(new Employee("Ana", 2));
        TL1.start(new Date());
        TL1.work();
        TL1.plan();
        TL1.end(new Date());

        TeamMember TM1 = new TeamMember(new Employee("Joana", 3));
        TM1.start(new Date());
        TM1.work();
        TM1.colaborate();
        TM1.end(new Date());

        Manager Man1 = new Manager(new Employee("Maria", 4));
        Man1.start(new Date());
        Man1.manage();
        Man1.end(new Date());


        TeamMember m2 = new TeamMember(new TeamLeader(new Employee ("Marcos", 5)));
        m2.start(new Date());
        m2.work();
        m2.colaborate();
        m2.end(new Date());

    }
}
