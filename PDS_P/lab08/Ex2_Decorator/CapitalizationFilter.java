package lab08.Ex2_Decorator;

public class CapitalizationFilter extends TextDecorator{
    
    public CapitalizationFilter(TextInterface text) {
        super(text);
    }

    @Override
    public boolean hasNext() {
        return text.hasNext();
    }

    @Override
    public String next() {
        String next = text.next();
        String[] words = next.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() > 1) {
                int lastIdx = word.length() - 1;
                char lastChar = word.charAt(lastIdx);
                // Verifica se o último caractere é uma letra ou não
                if (!Character.isLetter(lastChar)) {
                    // Se não for uma letra, mantém o último caractere como parte da palavra
                    lastIdx--;
                    lastChar = word.charAt(lastIdx);
                }
                sb.append(Character.toUpperCase(word.charAt(0)));
                sb.append(word.substring(1, lastIdx).toLowerCase());
                sb.append(Character.toUpperCase(lastChar));
                // Adiciona a pontuação final, se houver
                if (lastIdx < word.length() - 1) {
                    sb.append(word.substring(lastIdx + 1));
                }
            } else {
                sb.append(word.toUpperCase());
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }    
}
