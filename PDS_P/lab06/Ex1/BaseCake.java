package lab06.Ex1;

public abstract class BaseCake implements CakeBuilder {
    protected Cake cake = new Cake();

    @Override
    public void setCakeShape(Shape shape) {
        this.cake.setShape(shape);
    }

    @Override
    public void addCakeLayer() {
        this.cake.setNumCakeLayers(this.cake.getNumCakeLayers() + 1);
    }

    @Override
    public abstract void addCreamLayer();

    @Override
    public abstract void addTopLayer();

    @Override
    public abstract void addTopping();

    @Override
    public abstract void addMessage(String message);

    @Override
    public void createCake() {
        this.addCakeLayer();
        this.addCreamLayer();
        this.addTopLayer();
        this.addTopping();
    }

    @Override
    public Cake getCake() {
        return this.cake;
    }
}

