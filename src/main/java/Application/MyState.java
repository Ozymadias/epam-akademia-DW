package Application;

public class MyState {
    private static Prompt prompt = new Prompt();
    private static DirectoryPath directoryPath = new DirectoryPath();
    private static Statistics statistics = new Statistics();

    public static Statistics getStatistics() {
        return statistics;
    }

    public static Prompt getPrompt() {
        return prompt;
    }

    public static DirectoryPath getDirectoryPath() {
        return directoryPath;
    }
}
