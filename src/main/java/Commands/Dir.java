package Commands;

import Application.MyState;

public class Dir implements Command {
    public void execute(MyState state) {
        System.out.println(state.getDirectoryPath().getContentOf());
    }
}
