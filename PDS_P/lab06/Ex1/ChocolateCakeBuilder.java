package lab06.Ex1;

public class ChocolateCakeBuilder extends BaseCake {

    @Override
    public void addCakeLayer() {
        super.addCakeLayer();
        this.getCake().setCakeLayer("Soft chocolate");
    }

    @Override
    public void addCreamLayer() {
        this.getCake().setMidLayerCream(null);
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
