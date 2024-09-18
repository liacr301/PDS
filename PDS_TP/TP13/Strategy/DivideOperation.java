package TP13.Strategy;

public class DivideOperation implements Strategy{
    @Override
    public int execute(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return a / b;
    }
}
