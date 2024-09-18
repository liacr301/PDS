package lab09.Ex2;

class Employee{
    private double salary;
    private String name;
    private int empNumber;
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

    public void setEmpNum(int n) {
        empNumber = n;
    }

    public int getEmpNum() {
        return empNumber;
    }
}
