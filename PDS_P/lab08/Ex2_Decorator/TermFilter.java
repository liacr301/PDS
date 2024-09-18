package lab08.Ex2_Decorator;

public class TermFilter extends TextDecorator{
    public TermFilter(TextInterface text) {
        super(text);
    }

    @Override
    public boolean hasNext() {
        return text.hasNext();
    }

    @Override
    public String next() {
        String next = text.next();
        return next;
    }
}
