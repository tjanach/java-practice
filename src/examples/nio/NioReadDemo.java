package examples.nio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class NioReadDemo {

    public static void main(String[] args) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        try (
                Stream<String> lines = Files.lines(Paths.get("hamlet.txt"))
                ){
            System.out.println("=== Entire file ===");
            lines.forEach(line -> System.out.println(line));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
