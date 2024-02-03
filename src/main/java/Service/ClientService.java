package Service;

import Entiy.Player;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Handles client-side communication, sending a message to a server and processing responses.
 */
public class ClientService {

    public void connectAndSendMessage(String host, int port, Player player) {
        try (Socket socket = new Socket(host, port)) {
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Initiates sending a message and increments message count
            String messageToSend = "Hello, World! ";
            player.incrementMessageCount();

            //Send the message to the server (Player2)
            output.println(messageToSend);

            // Message service for processing messages
            MessageService messageService = new SimpleMessageService();

            String receivedMessage;

            // Receive and process player2 response messages in a round-robin fashion, while limiting the number of messages to no more than 10.
            while ((receivedMessage = input.readLine()) != null && player.getMessageCount() <= 10) {
                messageService.handleMessage(receivedMessage, output, player);
            }

        } catch (Exception e) {
            System.out.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
