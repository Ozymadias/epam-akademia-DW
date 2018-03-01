package application;

import directory.DirectoryPath;
import statistics.Statistics;

public class MyState {
    private static String prompt = "$";
    private static DirectoryPath directoryPath = new DirectoryPath();
    private static Statistics statistics = new Statistics();
    private static boolean isCwd = false;

    public static Statistics getStatistics() {
        return statistics;
    }

    static String getPrompt() {
        return (isCwd ? directoryPath.toString() : prompt) + ">";
    }

    public static DirectoryPath getDirectoryPath() {
        return directoryPath;
    }

    public static void handlePrompt(String newPrompt) {
        isCwd = "$cwd".equals(newPrompt);
        prompt = "reset".equals(newPrompt) ? "$" : newPrompt;
    }
}
