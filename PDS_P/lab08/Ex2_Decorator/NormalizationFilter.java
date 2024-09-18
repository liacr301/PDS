package lab08.Ex2_Decorator;

import java.text.Normalizer;

public class NormalizationFilter extends TextDecorator{
    public NormalizationFilter(TextInterface text) {
        super(text);
    }

    @Override
    public boolean hasNext() {
        return text.hasNext();
    }
    
    @Override
    public String next() {
        String next = text.next();
        // Remove acentuação
        next = Normalizer.normalize(next, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
        // Remove pontuação
        next = next.replaceAll("[\\p{Punct}&&[^']]", ""); // Mantém apóstrofos
        return next;
    }
}
