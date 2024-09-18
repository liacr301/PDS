package lab08.Ex2_Decorator;

import java.io.File;
import lab08.Ex2_Decorator.TextReader;

public class Main {
    public static void main(String[] args) {
        File file = new File("lab08/Ex2_Decorator/file.txt");
        TextInterface reader = new TextReader(file);

        int count = 1;
        while(reader.hasNext()){
            System.out.println("----Paragrafo " + count + " do texto: " + reader.next() + "----");
            count++;
        }

        System.out.println("\n----Texto sem acentos e pontuaçao: ----");
        reader = new NormalizationFilter(new TextReader(file));
        while(reader.hasNext()){
            System.out.println(reader.next());
        }

        System.out.println("\n----Texto sem vogais: ----");
        reader = new VowelFilter(new TermFilter(new TextReader(file)));
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }

        System.out.println("\n----Texto com a primeira e ultima letra em maiúsculas: ----");
        reader = new CapitalizationFilter(new TextReader(file));
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }

        System.out.println("\n----Texto com a primeira e ultima letra em maiúsculas e sem vogais: ----");
        reader = new CapitalizationFilter(new VowelFilter(new TextReader(file)));
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
    }
}
