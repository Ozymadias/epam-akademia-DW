package Commands;

import Application.MyState;

public class Cd implements Command {
    private String directory;

    public Cd(String directory) {
        this.directory = directory;
    }

    public void execute(MyState state) {
        state.getDirectoryPath().changeDirectoryTo(directory);
    }
}
