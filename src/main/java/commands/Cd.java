package commands;

import application.MyState;

class Cd implements Command {
    private String directory;
    private int tailLength;

    @Override
    public void execute() throws IllegalCommandUsageException {
        if (tailLength != 1)
            throw new IllegalCommandUsageException("Cd command needs argument");
        MyState.getDirectoryPath().changeDirectoryTo(directory);
    }

    @Override
    public void setTail(String part, int length) {
        this.directory = part;
        this.tailLength = length;
    }
}
