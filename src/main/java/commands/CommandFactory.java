package commands;

import application.IllegalCommandException;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    Map<String, Command> map = new HashMap<>();

    public CommandFactory() {
        map.put("cd", new Cd());
        map.put("dir", new Dir());
        map.put("pwd", new Pwd());
        map.put("tree", new Tree());
        map.put("prompt", new Prompt());
        map.put("statistics", new StatisticsCommand());
    }

    public Command getCommand(String input) throws IllegalCommandException {
        String[] parts = input.split(" ");
        if (!map.containsKey(parts[0]))
            throw new IllegalCommandException();
        Command command = map.get(parts[0]);
        command.setTail(parts.length > 1 ? parts[1] : "", parts.length - 1);
        return command;
    }
}
