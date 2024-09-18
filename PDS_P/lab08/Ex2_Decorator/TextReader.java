package lab08.Ex2_Decorator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TextReader implements TextInterface{
    private File fileName;
    private Scanner scanner;

    TextReader(File fileName) {
        this.fileName = fileName;
        try {
            scanner = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNextLine();
    }

    @Override
    public String next() {
        String paragraph = null;
        if (hasNext()) {
            paragraph = scanner.nextLine();
        }
        return paragraph;
    }
}
