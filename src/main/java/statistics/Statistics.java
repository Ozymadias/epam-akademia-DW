package statistics;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Statistics {
    private String[] commands = {"cd", "dir", "pwd", "tree", "prompt", "statistics"};
    private Map<String, Stat> commandStats;

    public Statistics() {
        this.commandStats = Arrays.stream(commands).collect(Collectors.toMap(c -> c, Stat::new));
    }

    @Override
    public String toString() {
        return commandStats.values().stream().map(Stat::toString).reduce((a, b) -> a + "\n" + b).orElse("Sth went wrong");
    }

    public void countSuccess(String part) {
        commandStats.get(part).incrementSuccessfulInvocations();
    }

    public void countFailure(String part) {
        commandStats.get(part).incrementUnsuccessfulInvocations();
    }
}
