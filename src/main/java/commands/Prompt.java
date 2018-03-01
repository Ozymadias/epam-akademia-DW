package commands;

import application.IllegalCommandUsageException;
import application.MyState;

public class Prompt implements Command {
    private String promptSign;
    private int tailLength;

    @Override
    public void execute() throws IllegalCommandUsageException {
        if (tailLength != 1)
            throw new IllegalCommandUsageException("Prompt command have to have argument");
        MyState.handlePrompt(promptSign);
    }

    @Override
    public void setTail(String part, int length) {
        this.promptSign = part;
        this.tailLength = length;
    }
}
