package Main;

import Entiy.Player;
import Service.MessageService;
import Service.SimpleMessageService;

public class PlayerCommunicationMain {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Message service for processing messages
        MessageService messageService = new SimpleMessageService();

        // Start sending the first message
        messageService.sendMessage(player1, player2, "Hello world ");
    }
}
