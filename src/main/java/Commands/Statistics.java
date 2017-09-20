package Commands;

import Application.MyState;

public class Statistics implements Command {
    @Override
    public void execute(MyState state) {
        System.out.println(state.getStatistics());
    }

    @Override
    public void setTail(String part, int length) {

    }
}
