package lab08.Ex2_Decorator;

public class VowelFilter extends TextDecorator {
    public VowelFilter(TextInterface text) {
        super(text);
    }

    @Override
    public boolean hasNext() {
        return text.hasNext();
    }

    @Override
    public String next() {
        String next = text.next();
        next = next.replaceAll("[aeiouAEIOU]", "");
        return next;
    }
}
