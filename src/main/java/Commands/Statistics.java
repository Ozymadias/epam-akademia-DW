package Commands;

import Application.IllegalCommandUsageException;
import Application.MyState;

public class Statistics implements Command {
    private String headOfTail;
    private int tailLength;

    @Override
    public void execute(MyState state) throws IllegalCommandUsageException {
        if (tailLength != 0)
            throw new IllegalCommandUsageException("Statistics command must not have argument");
        System.out.println(state.getStatistics());
    }

    @Override
    public void setTail(String part, int length) {
        this.headOfTail = part;
        this.tailLength = length;
    }
}
