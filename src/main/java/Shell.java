import java.io.File;
import java.util.Scanner;

public class Shell {

    private static String currentDirectoryPath = System.getProperty("user.dir");
    private static Prompt prompt = new Prompt();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!"exit".equals(input)) {
            System.out.print(prompt + ">");
            input = scanner.nextLine();
            if ("pwd".equals(input))
                System.out.println(currentDirectoryPath);
            if ("dir".equals(input))
                displayContentOf();
            String[] parts = input.split(" ");
            if ("cd".equals(parts[0]) && parts.length == 2)
                changeDirectoryTo(parts[1]);
            if ("prompt".equals((parts[0])) && parts.length == 2)
                prompt(parts[1]);
        }
        System.out.println("Bye");
    }

    private static void prompt(String part) {
        if("reset".equals(part))
            prompt.reset();
        else if("$cwd".equals(part))
            prompt.setPrompt(currentDirectoryPath);
        else
            prompt.setPrompt(part);
    }

    private static void changeDirectoryTo(String part) {
        if ("..".equals(part))
            changeToParent();
        else
            changeToChild(part);
    }

    private static void changeToChild(String part) {
        File currentDirectory = new File(currentDirectoryPath);
        File[] files = currentDirectory.listFiles();
        for (File file : files)
            if (file.getName().equals(part))
                currentDirectoryPath = file.getPath();
        //error Handling
    }

    private static void changeToParent() {
        File currentDirectory = new File(currentDirectoryPath);
        currentDirectoryPath = currentDirectory.getParent();
    }

    private static void displayContentOf() {
        File currentDirectory = new File(currentDirectoryPath);
        File[] files = currentDirectory.listFiles();
        for (File file : files) {
            if (file.isFile())
                System.out.println("FILE " + file);
            if (file.isDirectory())
                System.out.println("DIR  " + file);
        }
    }
}
