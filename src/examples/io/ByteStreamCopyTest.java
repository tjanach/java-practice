package examples.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamCopyTest {

    public static void main(String[] args) {

        byte[] b = new byte[128];

        try ( FileInputStream fis = new FileInputStream(args[0]);
              FileOutputStream fos = new FileOutputStream(args[1]) ) {
            System.out.println("Bytes available: "+fis.available());
            int count = 0; int read = 0;
            while ((read = fis.read(b))!= -1){
                fos.write(b);
                count+=read;
            }
            System.out.println("Wrote: "+count);
        } catch (FileNotFoundException ex){
            System.out.println("File not found: "+ex);
        } catch (IOException ex){
            System.out.println("IOException: "+ex);
        }

    }
}
