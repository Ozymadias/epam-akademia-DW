package Commands;

import Application.IllegalCommandUsageException;
import Application.MyState;

public class Tree implements Command {
    private String headOfTail;
    private int tailLength;

    @Override
    public void execute(MyState state) throws IllegalCommandUsageException {
        if (tailLength != 0)
            throw new IllegalCommandUsageException("Tree command must not have argument");
        System.out.println(state.getDirectoryPath().getTree());
    }

    @Override
    public void setTail(String part, int length) {
        this.headOfTail = part;
        this.tailLength = length;
    }
}
