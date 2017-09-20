package Application;

import Commands.Command;

import java.util.Scanner;

public class Shell {
    private static CommandFactory commandFactory = new CommandFactory();
    private static MyState state = new MyState();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!"exit".equals(input)) {
            System.out.print(state.getPrompt() + ">");
            input = scanner.nextLine();
            String[] parts = input.split(" ");
            Command command = commandFactory.getCommand(input);
            command.execute(state);
            state.getStatistics().count(parts[0]);
        }
        System.out.println("Bye");
    }

}
