import java.io.IOException;
import java.net.ServerSocket;

public class SimpleHTTPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080");
        while (true) {
            // spin forever
        }

    }
}
