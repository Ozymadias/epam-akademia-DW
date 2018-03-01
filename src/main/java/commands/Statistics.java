package commands;

import application.IllegalCommandUsageException;
import application.MyState;

public class Statistics implements Command {
    private int tailLength;

    @Override
    public void execute() throws IllegalCommandUsageException {
        if (tailLength != 0)
            throw new IllegalCommandUsageException("Statistics command must not have argument");
        System.out.println(MyState.getStatistics());
    }

    @Override
    public void setTail(String part, int length) {
        this.tailLength = length;
    }
}
