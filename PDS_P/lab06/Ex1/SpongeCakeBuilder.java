package lab06.Ex1;

public class SpongeCakeBuilder extends BaseCake {

    @Override
    public void addCakeLayer() {
        super.addCakeLayer();
        this.getCake().setCakeLayer("Sponge cake");
    }

    @Override
    public void addCreamLayer() {
        this.getCake().setMidLayerCream(Cream.Red_Berries);
    }

    @Override
    public void addTopLayer() {
        this.getCake().setTopLayerCream(Cream.Whipped_Cream);
    }

    @Override
    public void addTopping() {
        this.getCake().setTopping(Topping.Fruit);
    }

    @Override
    public void addMessage(String message) {
        this.getCake().setMessage(message);
    }
}
