package Commands;

import Application.MyState;

public class Prompt implements Command {
    private String prompt;
    private int tailLength;

    @Override
    public void execute(MyState state) {
        state.handlePrompt(prompt);
    }

    @Override
    public void setTail(String part, int length) {
        this.prompt = part;
        this.tailLength = length;
    }
}
