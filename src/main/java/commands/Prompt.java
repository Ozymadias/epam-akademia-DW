package commands;

import application.MyState;

class Prompt implements Command {
    private String promptSign;
    private int tailLength;

    @Override
    public void execute() throws IllegalCommandUsageException {
        if (tailLength != 1)
            throw new IllegalCommandUsageException("Prompt command needs argument");
        MyState.handlePrompt(promptSign);
    }

    @Override
    public void setTail(String part, int length) {
        this.promptSign = part;
        this.tailLength = length;
    }
}
