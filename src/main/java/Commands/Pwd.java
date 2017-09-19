package Commands;

import Application.MyState;

public class Pwd implements Command {
    public void execute(MyState state) {
        System.out.println(state.getDirectoryPath());
    }
}
