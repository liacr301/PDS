package lab04.gp409.lab03.FlightsPackage;

public enum ClassType {
    T, E;

    @java.lang.Override
    public java.lang.String toString() {
        return switch (this){
            case T -> "Tourist";
            case E -> "Executive";
        };
    }
}