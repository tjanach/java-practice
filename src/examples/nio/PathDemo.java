package examples.nio;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {

    public static void main(String[] args) {
        Path p = Paths.get("/home/tjanach/projects/projectX");
        System.out.format("getFileName(): %s%n", p.getFileName());
        System.out.format("getParent(): %s%n", p.getParent());
        System.out.format("getNameCount(): %d%n", p.getNameCount());
        System.out.format("getRoot(): %s%n", p.getRoot());
        System.out.format("isAbsolute(): %b%n", p.isAbsolute());
        System.out.format("toAbsolutePath(): %s%n", p.toAbsolutePath());
        System.out.format("toUri(): %s%n", p.toUri());
        System.out.format("subpath(1,3): %s%n", p.subpath(1,3));
        System.out.format("resolve('file.xyz'): %s%n", p.resolve("file.xyz"));

        System.out.println("");
        System.out.println("WINDOWS PATH");
        System.out.println("");

        p = Paths.get("C:\\Users\\janastom\\Documents\\private\\ala.txt");
        System.out.format("getFileName(): %s%n", p.getFileName());
        System.out.format("getParent(): %s%n", p.getParent());
        System.out.format("getNameCount(): %d%n", p.getNameCount());
        System.out.format("getRoot(): %s%n", p.getRoot());
        System.out.format("isAbsolute(): %b%n", p.isAbsolute());
        System.out.format("toAbsolutePath(): %s%n", p.toAbsolutePath());
        System.out.format("toUri(): %s%n", p.toUri());
        System.out.format("subpath(1,3): %s%n", p.subpath(1,3));
        System.out.format("resolve('file.xyz'): %s%n", p.resolve("file.xyz"));

        p = Paths.get("/qqq/./sss/ccc");
        System.out.format("normalize(): %s%n", p.normalize());
        p = Paths.get("/aaa/../bbb");
        System.out.format("normalize(): %s%n", p.normalize());
    }
}
