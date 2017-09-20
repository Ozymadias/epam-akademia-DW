package Application;

public class Statistics {
    private String[] commands = {"cd", "pwd", "tree", "prompt", "statistics"};
    private int numberOfCommands = commands.length;
    private int[][] numberOfInvocations = new int[numberOfCommands][2];


    public Statistics() {
        for (int i = 0; i < numberOfCommands; i++) {
            numberOfInvocations[i][0] = 0;
            numberOfInvocations[i][1] = 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberOfCommands; i++)
            stringBuilder
                    .append(commands[i])
                    .append(":")
                    .append(numberOfInvocations[i][0])
                    .append(":")
                    .append(numberOfInvocations[i][1])
                    .append("\n");
        return stringBuilder.toString();
    }

    public void count(String commandName, int successOrNot) {
        for (int i = 0; i < numberOfCommands; i++)
            if (commands[i].equals(commandName))
                numberOfInvocations[i][successOrNot]++;
    }

    public void countSuccess(String part) {
        count(part, 0);
    }

    public void countFailure(String part) {
        count(part, 1);
    }
}
