package Main.Multi_Process;

import Entiy.Player;
import Service.ServerService;


public class Player2_Server {
    public static void main(String[] args) {
        // Port number of the server listening
        int port = 12345;

        // Server-side player
        Player player = new Player("Player2");

        // Start the server and listen for client messages
        ServerService serverService = new ServerService();
        serverService.startServer(port, player);
    }
}
