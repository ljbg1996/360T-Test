package Main.Multi_Process;

import Entiy.Player;
import Service.ClientService;


public class Player1_Client {
    public static void main(String[] args) {
        // Hostname and port number of the client connection
        String host = "localhost";
        int port = 12345;

        // Client-side player
        Player player = new Player("Player1");

        // Connect to the server and send a message
        ClientService clientService = new ClientService();
        clientService.connectAndSendMessage(host, port, player);
    }
}
