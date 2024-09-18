package TP13.Strategy;

public class AddOperation implements Strategy{
    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}
