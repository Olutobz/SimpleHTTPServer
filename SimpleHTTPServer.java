import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * Java program to create a simple HTTP Server to demonstrate how to use
 * ServerSocket and Socket class.
 *
 * @author Onikoyi Damola Olutoba
 * @since 12/01/2022
 */

public class SimpleHTTPServer {

    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ...");
        while (true) {
            // spin forever
            try (final Socket clientSocket = server.accept()) {
                InputStreamReader streamReader = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                String line = reader.readLine();
                while (!line.isEmpty()) {
                    System.out.println(line);
                    line = reader.readLine();
                }
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                clientSocket.getOutputStream().write(httpResponse.getBytes(StandardCharsets.UTF_8));

            }
        }
    }
}
