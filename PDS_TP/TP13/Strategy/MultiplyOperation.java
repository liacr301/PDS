package TP13.Strategy;

public class MultiplyOperation implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}
