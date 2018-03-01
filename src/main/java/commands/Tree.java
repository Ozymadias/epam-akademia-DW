package commands;

import application.MyState;

class Tree implements Command {
    private int tailLength;

    @Override
    public void execute() throws IllegalCommandUsageException {
        if (tailLength != 0)
            throw new IllegalCommandUsageException("Tree command must not have argument");
        System.out.println(MyState.getDirectoryPath().getTree());
    }

    @Override
    public void setTail(String part, int length) {
        this.tailLength = length;
    }
}
