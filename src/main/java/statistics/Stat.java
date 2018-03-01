package statistics;

public class Stat {
    private String commandName;
    private int numberOfSuccessfulInvocations;
    private int numberOfUnsuccessfulInvocations;

    public Stat(String commandName) {
        this.commandName = commandName;
        this.numberOfSuccessfulInvocations = 0;
        this.numberOfUnsuccessfulInvocations = 0;
    }

    @Override
    public String toString() {
        return commandName + ":" + numberOfSuccessfulInvocations + ":" + numberOfUnsuccessfulInvocations;
    }

    public void incrementSuccessfulInvocations() {
        numberOfSuccessfulInvocations++;
    }

    public void incrementUnsuccessfulInvocations() {
        numberOfUnsuccessfulInvocations++;
    }
}
