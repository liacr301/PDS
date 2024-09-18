package lab12.Ex5_Visitor;

import java.io.IOException;
import java.nio.file.*;
import java.text.DecimalFormat;

public class SizeOfDirectory {
    public static void main(String[] args) {
        boolean recursive = false;
        Path rootPath = null;
        for (String arg : args) {
            if (arg.equals("-r")) {
                recursive = true;
            } else {
                rootPath = Paths.get(arg);
            }
        }
        if (rootPath == null) {
            System.out.println("Usage: java SizeOfDirectory [-r] <directory>");
            return;
        }
        try {
            SizeVisitor visitor = new SizeVisitor(recursive);
            Files.walkFileTree(rootPath, visitor);
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("Total: " + df.format((double)visitor.getTotalSize()/1024) + " kB");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

