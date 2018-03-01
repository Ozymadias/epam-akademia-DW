package commands;

import application.IllegalCommandUsageException;
import application.MyState;

public class Pwd implements Command {
    private int tailLength;

    @Override
    public void execute() throws IllegalCommandUsageException {
        if (tailLength != 0)
            throw new IllegalCommandUsageException("Pwd command must not have argument");
        System.out.println(MyState.getDirectoryPath());
    }

    @Override
    public void setTail(String part, int length) {
        this.tailLength = length;
    }
}
