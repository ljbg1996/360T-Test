package Service;

import Entiy.Player;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Manages server-side operations, accepting client connections and processing messages.
 */
public class ServerService {

    /**
     * Starts the server on the specified port and listens for incoming client connections.
     *
     * @param port    The port on which the server will listen.
     * @param player  The player associated with this server instance.
     */
    public void startServer(int port, Player player) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println(player.getName() + " is listening on port " + port);
            while (true) {
                // Waiting for and accepting client connections
                Socket socket = serverSocket.accept();

                // Processing client connections
                handleClientConnection(socket, player);
            }
        } catch (Exception e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void handleClientConnection(Socket socket, Player player) {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

            // Message service for processing messages
            MessageService messageService = new SimpleMessageService();

            String receivedMessage;

            // Receive and process player1 response messages in a round-robin fashion, while limiting the number of messages to no more than 10.
            while ((receivedMessage = input.readLine()) != null && player.getMessageCount() <= 10) {
                messageService.handleMessage(receivedMessage, output, player);
            }
        } catch (Exception e) {
            System.out.println("Error handling client connection: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                System.out.println("Error closing socket: " + e.getMessage());
            }
        }
    }
}
