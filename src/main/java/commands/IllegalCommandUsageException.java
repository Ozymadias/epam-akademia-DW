package commands;

public class IllegalCommandUsageException extends Exception {
    public IllegalCommandUsageException(String message) {
        super(message);
    }
}
