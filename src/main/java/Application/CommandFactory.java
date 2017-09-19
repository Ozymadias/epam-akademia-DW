package Application;

import Commands.*;
import Commands.Prompt;
import Commands.Statistics;

public class CommandFactory {
    public Command getCommand(String input) {
        String[] parts = input.split(" ");
        if ("pwd".equals(input))
            return new Pwd();
        if ("dir".equals(input))
            return new Dir();
        if ("cd".equals(parts[0]) && parts.length == 2)
            return new Cd(parts[1]);
        if ("prompt".equals((parts[0])) && parts.length == 2)
            return new Prompt(parts[1]);
        if ("tree".equals(input))
            return new Tree();
        if ("statistics".equals(input))
            return new Statistics();
        return new InvalidCommand();
    }
}
