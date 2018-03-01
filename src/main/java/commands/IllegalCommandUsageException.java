package commands;

public class IllegalCommandUsageException extends Exception {
    IllegalCommandUsageException(String message) {
        super(message);
    }
}
