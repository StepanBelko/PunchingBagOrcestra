package by.itstep.stpnbelko.javastages.stage20.view;

import java.io.FileOutputStream;
import java.io.IOException;

public class Writer {
    public static void writeToFile(String msg, String filePath, boolean append) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath, append)) {

            byte[] buffer = msg.getBytes();

            fileOutputStream.write(buffer, 0, buffer.length);

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
