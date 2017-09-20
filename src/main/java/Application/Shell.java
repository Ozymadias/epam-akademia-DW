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
            try {
                Command command = commandFactory.getCommand(input);
                command.execute(state);
                state.getStatistics().countSuccess(parts[0]);
            } catch (IllegalCommandUsageException e) {
                System.out.println(e.getMessage());
                state.getStatistics().countFailure(parts[0]);
            }
            catch (IllegalCommandException e){
                System.out.println(parts[0] + " : unknown command");
            }
        }
        System.out.println("Bye");
    }

}
