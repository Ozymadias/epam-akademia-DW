package commands;

import application.MyState;

class StatisticsCommand implements Command {
    private int tailLength;

    @Override
    public void execute() throws IllegalCommandUsageException {
        if (tailLength != 0)
            throw new IllegalCommandUsageException("StatisticsCommand command must not have argument");
        System.out.println(MyState.getStatistics());
    }

    @Override
    public void setTail(String part, int length) {
        this.tailLength = length;
    }
}
