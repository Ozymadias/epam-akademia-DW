package Commands;

import Application.MyState;

public class Tree implements Command {
    public void execute(MyState state) {
        System.out.println(state.getDirectoryPath().getTree());
    }
}
