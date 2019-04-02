import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void append(String str)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true));
        writer.append(str+"\n");
        writer.close();
    }
}
