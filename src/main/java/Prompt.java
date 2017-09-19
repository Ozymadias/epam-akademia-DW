public class Prompt {
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
}
