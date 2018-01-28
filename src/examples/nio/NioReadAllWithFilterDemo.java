package examples.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class NioReadAllWithFilterDemo {

    public static void main(String[] args) {

        List<String> fileArr;
        Path p = Paths.get("hamlet.txt");
        try {
            fileArr = Files.readAllLines(p);

            System.out.println("=== Rozencrantz ===");
            fileArr.stream()
                    .filter(line -> line.contains("Ros."))
                    .forEach(line -> System.out.println(line));

            System.out.println("=== Guildenstern ===");
            fileArr.stream()
                    .filter(line -> line.contains("Guil."))
                    .forEach(line -> System.out.println(line));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
