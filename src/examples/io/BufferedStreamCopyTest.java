package examples.io;

import java.io.*;

public class BufferedStreamCopyTest {

    public static void main(String[] args) {
        try (BufferedReader buffInput = new BufferedReader(new FileReader(args[0]));
             BufferedWriter buffOutput = new BufferedWriter(new FileWriter(args[1]))) {
            int count = 0;
            String line = "";
            while ((line = buffInput.readLine()) != null){
                buffOutput.write(line);
                buffOutput.newLine();
                count++;
            }
            System.out.println("Wrote: "+count+" lines");
        } catch (FileNotFoundException ex){
            System.out.println("File not found: "+ex);
        } catch (IOException ex){
            System.out.println("IOException: "+ex);
        }

    }
}
