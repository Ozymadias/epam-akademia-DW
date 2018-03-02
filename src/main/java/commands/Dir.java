package commands;

import application.MyState;

class Dir implements Command {
    private int tailLength;

    @Override
    public void execute() throws IllegalCommandUsageException {
        if (tailLength != 0)
            throw new IllegalCommandUsageException("Dir command must not have argument");
        System.out.print(MyState.getDirectoryPath().getContentOf());
    }

    @Override
    public void setTail(String part, int length) {
        this.tailLength = length;
    }
}
