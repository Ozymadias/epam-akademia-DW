package Commands;

import Application.MyState;

public class Pwd implements Command {
    @Override
    public void execute(MyState state) {
        System.out.println(state.getDirectoryPath());
    }

    @Override
    public void setTail(String part, int length) {

    }
}
