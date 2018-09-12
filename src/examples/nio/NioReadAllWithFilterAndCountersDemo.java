package examples.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class NioReadAllWithFilterAndCountersDemo {

    public static void main(String[] args) {

        List<String> fileArr;
        Path p = Paths.get("hamlet.txt");
        try {
            fileArr = Files.readAllLines(p);

            System.out.println("=== Lord count ===");
            long wordCount = fileArr.stream()
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .filter(word -> word.contains("lord"))
                    .peek(word -> System.out.println(word))
                    .count();
            System.out.println("Word count: " + wordCount);

            System.out.println("=== Prison count ===");
            wordCount = fileArr.stream()
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .filter(word -> word.contains("prison"))
                    .peek(word -> System.out.println(word))
                    .count();
            System.out.println("Word count: " + wordCount);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}