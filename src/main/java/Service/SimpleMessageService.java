package Service;

import Entiy.Player;

import java.io.PrintWriter;

/**
 * Implements basic messaging functionalities.
 */
public class SimpleMessageService implements MessageService{
    @Override
    public void sendMessage(Player sender, Player receiver, String message) {
        // Initiates sending a message and increments message count
        if (sender.getMessageCount() == 0) {
            sender.incrementMessageCount();
        }
        handleMessage(receiver, sender, message);
    }

    // Processes received message and sends a response, which was used for single-process tasks.
    @Override
    public void handleMessage(Player receiver, Player sender, String message) {
        System.out.println(receiver.getName() + " received message from " + sender.getName() + ": " + message);
        if (receiver.getMessageCount() < 10) {
            receiver.incrementMessageCount();
            String response = message + receiver.getMessageCount() + " ";
            sendMessage(receiver, sender, response);
        }
    }

    // Handles incoming message and sends a response, which was used for multi-process tasks.
    @Override
    public void handleMessage(String message, PrintWriter output, Player player) {
        System.out.println(player.getName() +  " received : "+ message);
        if (player.getMessageCount() < 10) {
            player.incrementMessageCount();
            String response = message + " " + player.getMessageCount();
            output.println(response);
        }
    }
}
