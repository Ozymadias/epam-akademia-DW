package Commands;

import Application.MyState;

public class Dir implements Command {
    @Override
    public void execute(MyState state) {
        System.out.println(state.getDirectoryPath().getContentOf());
    }

    @Override
    public void setTail(String part, int length) {

    }
}
