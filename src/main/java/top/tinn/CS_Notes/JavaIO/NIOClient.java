package top.tinn.CS_Notes.JavaIO;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class NIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();
        String s = "hello NIOServer!";
        out.write(s.getBytes());
        out.close();
    }
}
