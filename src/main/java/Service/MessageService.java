package Service;

import Entiy.Player;

import java.io.PrintWriter;

/**
 * Interface defining messaging services including sending, receiving, and handling messages.
 */
public interface MessageService {
    void sendMessage(Player sender, Player receiver, String message);
    void handleMessage(Player receiver, Player sender, String message);
    void handleMessage(String message, PrintWriter output, Player player);
}