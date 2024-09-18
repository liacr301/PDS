package lab12.Ex5_Visitor;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DecimalFormat;

public class SizeVisitor extends SimpleFileVisitor<Path> {
    private long totalSize = 0;
    private long grandTotalSize = 0;
    private boolean recursive;
    private DecimalFormat df = new DecimalFormat("#.##");

    public SizeVisitor(boolean recursive) {
        this.recursive = recursive;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        long fileSize = attrs.size();
        totalSize += fileSize;
        grandTotalSize += fileSize;
        if (recursive) {
            System.out.println(file + ": " + df.format((double)fileSize/1024) + " kB");
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (!recursive) {
            totalSize = 0;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println(dir + ": " + df.format((double)totalSize/1024) + " kB");
        if (recursive) {
            totalSize = 0;
        }
        return FileVisitResult.CONTINUE;
    }

    public long getTotalSize() {
        return grandTotalSize;
    }
}
