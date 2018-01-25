package examples.io;

import java.io.*;

public class CharStreamCopyTest {

    public static void main(String[] args) {

        char[] c = new char[128];

        try (FileReader fr = new FileReader(args[0]);
             FileWriter fw = new FileWriter(args[1]) ) {
            int count = 0; int read = 0;
            while ((read = fr.read(c))!= -1){
                fw.write(c);
                count+=read;
            }
            System.out.println("Wrote: "+count+" characters");
        } catch (FileNotFoundException ex){
            System.out.println("File not found: "+ex);
        } catch (IOException ex){
            System.out.println("IOException: "+ex);
        }

    }
}
