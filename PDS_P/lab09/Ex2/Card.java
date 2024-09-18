package lab09.Ex2;

public class Card {
    
    private Employee employee;

    public Card(Employee e) {
        this.employee = e;
    }

    @Override
    public String toString() {
        return "Cartão de " + employee.getName();
    }
    
}
