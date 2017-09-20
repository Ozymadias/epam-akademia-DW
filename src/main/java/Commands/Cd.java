package Commands;

import Application.MyState;

public class Cd implements Command {
    private String directory;
    private int tailLength;

    @Override
    public void execute(MyState state) {
        state.getDirectoryPath().changeDirectoryTo(directory);
    }

    @Override
    public void setTail(String part, int length) {
        this.directory = part;
        this.tailLength = length;
    }
}
