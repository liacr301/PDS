package lab08.Ex2_Decorator;

public abstract class TextDecorator implements TextInterface {
    protected TextInterface text;

    public TextDecorator(TextInterface text) {
        this.text = text;
    }

    @Override
    public boolean hasNext() {
        return text.hasNext();
    }

    @Override
    public String next() {
        return text.next();
    }
}