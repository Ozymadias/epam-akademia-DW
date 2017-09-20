package Commands;

import Application.IllegalCommandUsageException;
import Application.MyState;

public class Cd implements Command {
    private String directory;
    private int tailLength;

    @Override
    public void execute(MyState state) throws IllegalCommandUsageException {
        if (tailLength != 1)
            throw new IllegalCommandUsageException("Improper directory passed to cd command!");
        state.getDirectoryPath().changeDirectoryTo(directory);
    }

    @Override
    public void setTail(String part, int length) {
        this.directory = part;
        this.tailLength = length;
    }
}
