package Commands;

import Application.MyState;

public class Tree implements Command {
    @Override
    public void execute(MyState state) {
        System.out.println(state.getDirectoryPath().getTree());
    }

    @Override
    public void setTail(String part, int length) {

    }
}
