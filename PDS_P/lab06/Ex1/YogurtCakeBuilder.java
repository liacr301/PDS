package lab06.Ex1;

public class YogurtCakeBuilder extends BaseCake {
    @Override
    public void addCakeLayer() {
        super.addCakeLayer();
        this.getCake().setCakeLayer("Yogurt cake");
    }

    @Override
    public void addCreamLayer() {
        this.getCake().setMidLayerCream(Cream.Vanilla);
    }

    @Override
    public void addTopLayer() {
        this.getCake().setTopLayerCream(Cream.Red_Berries);
    }

    @Override
    public void addTopping() {
        this.getCake().setTopping(Topping.Chocolate);
    }

    @Override
    public void addMessage(String message) {
        this.getCake().setMessage(message);
    }
}