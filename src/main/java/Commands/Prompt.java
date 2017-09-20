package Commands;

import Application.IllegalCommandUsageException;
import Application.MyState;

public class Prompt implements Command {
    private String prompt;
    private int tailLength;

    @Override
    public void execute(MyState state) throws IllegalCommandUsageException {
        if (tailLength != 1)
            throw new IllegalCommandUsageException("Prompt command have to have argument");
        state.handlePrompt(prompt);
    }

    @Override
    public void setTail(String part, int length) {
        this.prompt = part;
        this.tailLength = length;
    }
}
