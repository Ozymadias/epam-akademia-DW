package Application;

public class MyState {
    private static String prompt = "$";
    private static DirectoryPath directoryPath = new DirectoryPath();
    private static Statistics statistics = new Statistics();

    private static boolean isCwd = false;

    public static Statistics getStatistics() {
        return statistics;
    }

    public static String getPrompt() {
        if (!isCwd)
            return prompt;
        else
            return directoryPath.toString();
    }

    public static DirectoryPath getDirectoryPath() {
        return directoryPath;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void handlePrompt(String prompt) {
        if ("$cwd".equals(prompt))
            isCwd = true;
        else {
            isCwd = false;
            setPrompt(("reset".equals(prompt)) ? "$" : prompt);
        }
    }
}
