package Application;

import Commands.*;
import Commands.Prompt;
import Commands.Statistics;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    Map<String, Command> map = new HashMap<>();

    public CommandFactory() {
        map.put("pwd", new Pwd());
        map.put("dir", new Dir());
        map.put("tree", new Tree());
        map.put("statistics", new Statistics());
        map.put("cd", new Cd());
        map.put("prompt", new Prompt());
    }

    public Command getCommand(String input) {
        String[] parts = input.split(" ");
        if (!map.containsKey(parts[0]))
            return new InvalidCommand();
        Command command = map.get(parts[0]);
        command.setTail(parts.length > 1 ? parts[1] : "", parts.length);
        return command;
    }
}
