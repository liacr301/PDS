package lab06.Ex1;

public class Cake {
    private Shape shape;
    private String cakeLayer;
    private int numCakeLayers;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;

    public Cake() {
        this.shape = Shape.Circle;
        this.numCakeLayers = 1;
    }


    // Getters and setters
    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public String getCakeLayer() {
        return cakeLayer;
    }

    public void setCakeLayer(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    public int getNumCakeLayers() {
        return numCakeLayers;
    }

    public void setNumCakeLayers(int numCakeLayers) {
        this.numCakeLayers = numCakeLayers;
    }

    public Cream getMidLayerCream() {
        return midLayerCream;
    }

    public void setMidLayerCream(Cream midLayerCream) {
        this.midLayerCream = midLayerCream;
    }

    public Cream getTopLayerCream() {
        return topLayerCream;
    }

    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        switch (shape) {
            case Square:
                sb.append("Square ");
                break;
            case Rectangle:
                sb.append("Rectangular ");
                break;
            default:
                sb.append("Circular ");
        }

        sb.append(cakeLayer).append(" with ").append(numCakeLayers).append(" layer");
        if (numCakeLayers > 1) {
            sb.append("s");
        }

        if (midLayerCream != null) {
            sb.append(" and ").append(midLayerCream).append(" cream");
        }

        sb.append(", topped with ").append(topLayerCream).append(" cream and ").append(topping)
          .append(". Message says: \"").append(message).append("\".");

        return sb.toString();
    }
}