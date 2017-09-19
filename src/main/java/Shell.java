import java.util.Scanner;

public class Shell {

    private static Prompt prompt = new Prompt();
    private static DirectoryPath directoryPath = new DirectoryPath();
    private static Statistics statistics = new Statistics();
    private static CommandsHandler commandsHandler = new CommandsHandler();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!"exit".equals(input)) {
            System.out.print(prompt + ">");
            input = scanner.nextLine();
            String[] parts = input.split(" ");
            commandsHandler.handle(input);
            if ("pwd".equals(input))
                System.out.println(directoryPath);
            if ("dir".equals(input))
                System.out.println(directoryPath.getContentOf());
            if ("cd".equals(parts[0]) && parts.length == 2)
                directoryPath.changeDirectoryTo(parts[1]);
            if ("prompt".equals((parts[0])) && parts.length == 2)
                prompt(parts[1]);
            if ("tree".equals(input))
                System.out.println(directoryPath.getTree());
            if ("statistics".equals(input))
                System.out.println(statistics);
            statistics.count(parts[0]);
        }
        System.out.println("Bye");
    }

    private static void prompt(String part) {
        if ("reset".equals(part))
            prompt.reset();
        else if ("$cwd".equals(part))
            prompt.setPrompt(directoryPath.toString());
        else
            prompt.setPrompt(part);
    }

}
