package lab06.Ex1;

public class CakeMaster {
    private CakeBuilder builder;

    public void setCakeBuilder(CakeBuilder builder) {
        this.builder = builder;
    }

    public Cake getCake() {
        return builder.getCake();
    }

    public void createCake(String message) {
        builder.createCake();
        builder.addMessage(message);
    }

    public void createCake(int layers, String message) {
        builder.createCake();
        for (int i = 0; i < layers; i++) {
            builder.addCakeLayer();
        }
        builder.addMessage(message);
    }

    public void createCake(Shape shape, int layers, String message) {
        builder.createCake();
        builder.setCakeShape(shape);
        for (int i = 0; i < layers; i++) {
            builder.addCakeLayer();
        }
        builder.addMessage(message);
    }
}
