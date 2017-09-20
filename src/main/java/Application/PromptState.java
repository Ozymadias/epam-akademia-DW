package Application;

public class PromptState {
    private String prompt = "$";

    @Override
    public String toString() {
        return prompt;
    }

    public void reset() {
        prompt = "$";
    }

    public void setPrompt(String newPrompt) {
        prompt = newPrompt;
    }

    public void handle(String s, MyState state) {
        if ("reset".equals(s))
            reset();
        else if ("$cwd".equals(s))
            setPrompt(state.getDirectoryPath().toString());
        else
            setPrompt(s);
    }
}
