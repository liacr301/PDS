package lab07.Ex3_Adapter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Document {
    private String content;

    public Document(String filePath) {
        try {
            this.content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getContent() {
        return content;
    }
}
