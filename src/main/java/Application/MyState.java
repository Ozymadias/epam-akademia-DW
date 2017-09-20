package Application;

public class MyState {
    private static PromptState promptState = new PromptState();
    private static DirectoryPath directoryPath = new DirectoryPath();
    private static Statistics statistics = new Statistics();

    public static Statistics getStatistics() {
        return statistics;
    }

    public static PromptState getPromptState() {
        return promptState;
    }

    public static DirectoryPath getDirectoryPath() {
        return directoryPath;
    }
}
