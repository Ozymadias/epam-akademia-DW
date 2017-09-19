package Commands;

import Application.MyState;

public class Statistics implements Command {
    public void execute(MyState state) {
        System.out.println(state.getStatistics());
    }
}
