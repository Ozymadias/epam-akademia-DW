import java.util.Arrays;

public class Statistics {
    private String[] commands = {"pwd", "cd", "tree", "prompt", "statistics"};
    private int numberOfCommands = commands.length;
    private int[] numberOfSuccessfulInvocations = new int[numberOfCommands];
    private int[] numberOfUnsuccessfulInvocations = new int[numberOfCommands];


    public Statistics() {
        for (int i = 0; i < numberOfCommands; i++) {
            numberOfSuccessfulInvocations[i] = 0;
            numberOfUnsuccessfulInvocations[i] = 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberOfCommands; i++)
            stringBuilder
                    .append(commands[i])
                    .append(":")
                    .append(numberOfSuccessfulInvocations[i])
                    .append(":")
                    .append(numberOfUnsuccessfulInvocations[i])
                    .append("\n");
        return stringBuilder.toString();
    }

    public void count(String commandName) {
        for(int i = 0; i < numberOfCommands; i++)
            if(commands[i].equals(commandName))
                numberOfSuccessfulInvocations[i]++;
    }
}
