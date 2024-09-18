package lab06.Ex1;

public class StrawberryCakeBuilder extends BaseCake {
    @Override
    public void addCakeLayer() {
        super.addCakeLayer();
        this.getCake().setCakeLayer("Strawberry cake");
    }
    @Override
    public void addCreamLayer() {
        this.getCake().setMidLayerCream(Cream.Strawberry);
    }

    @Override
    public void addTopLayer() {
        this.getCake().setTopLayerCream(Cream.Strawberry);
    }

    @Override
    public void addTopping() {
        this.getCake().setTopping(Topping.Strawberry);
    }

    @Override
    public void addMessage(String message) {
        this.getCake().setMessage(message);
    }
}