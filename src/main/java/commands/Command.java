package commands;

import application.IllegalCommandUsageException;

public interface Command {
    void execute() throws IllegalCommandUsageException;

    void setTail(String part, int length);
}
