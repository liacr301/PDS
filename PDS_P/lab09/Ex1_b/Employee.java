package lab09.Ex1_b;

class Employee{
    private double salary;
    private String name;
    private BankAccount bankAccount;

    public Employee(String n, double s) {
        name = n;
        bankAccount = new BankAccountImpl("PeDeMeia", 0);
        salary = s;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
