package lab09.Ex2;

import java.util.ArrayList;
import java.util.List;

public class Facade extends Company{
    private int numEmp = 1;
    private Company company = new Company();
    private SocialSecurity socialSecurity = new SocialSecurity();
    private Insurance insurance = new Insurance();
    private List<Card> card = new ArrayList<Card>();
    private Parking parking = new Parking();

    public void admitEmployee(String n, double salary){
        Employee emp = new Employee(n, salary);
        emp.setEmpNum(this.numEmp);
        this.numEmp ++;
        company.admitEmployee(n, salary);
        Card cartao = new Card(emp);
        card.add(cartao);
        System.out.println(cartao.toString());
        socialSecurity.regist(emp);
        parking.allow(emp, this.company);
        insurance.regist(emp);
    }

    public Company getCompany(){
        return company;
    }
}
