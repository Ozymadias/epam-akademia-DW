package commands;

public class IllegalCommandException extends Exception{
    IllegalCommandException(String part) {
        super(part + " : unknown command");
    }
}
