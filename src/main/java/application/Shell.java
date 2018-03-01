package application;

import commands.Command;
import commands.CommandFactory;

import java.util.Scanner;

public class Shell {
    private static CommandFactory commandFactory = new CommandFactory();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!"exit".equals(input)) {
            System.out.print(MyState.getPrompt() + ">");
            input = scanner.nextLine();
            String[] parts = input.split(" ");
            try {
                Command command = commandFactory.getCommand(input);
                command.execute();
                MyState.getStatistics().countSuccess(parts[0]);
            } catch (IllegalCommandUsageException e) {
                System.out.println(e.getMessage());
                MyState.getStatistics().countFailure(parts[0]);
            }
            catch (IllegalCommandException e){
                System.out.println(parts[0] + " : unknown command");
            }
        }
        System.out.println("Bye");
    }

}
