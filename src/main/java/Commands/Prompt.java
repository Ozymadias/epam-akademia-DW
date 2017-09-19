package Commands;

import Application.MyState;

public class Prompt implements Command {
    private final String prompt;

    public Prompt(String prompt) {
        this.prompt = prompt;
    }

    public void execute(MyState state) {
        state.getPrompt().handle(prompt, state);
    }
}
