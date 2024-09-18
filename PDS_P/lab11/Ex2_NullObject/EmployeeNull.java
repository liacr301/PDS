package lab11.Ex2_NullObject;

public class EmployeeNull extends Employee {
    public EmployeeNull(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name + ": This name does not exist";
    }
}

