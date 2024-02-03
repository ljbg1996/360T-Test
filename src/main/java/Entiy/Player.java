package Entiy;

/**
 * Represents a player with a name and a count of messages sent or received.
 */
public class Player {
    private String name;
    private int messageCount;

    public Player(String name) {
        this.name = name;
        this.messageCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMessageCount() {
        return messageCount;
    }

    /**
     * Increments the count of messages by one instead of set-method.
     */
    public void incrementMessageCount() {
        this.messageCount +=1;
    }
}
