package examples.nio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {

    public static void main(String[] args) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        try (
                BufferedReader br = new BufferedReader(new FileReader("hamlet.txt"))
                ){
            System.out.println("=== Entire file ===");
            br.lines()
                    .forEach(line -> System.out.println(line));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
