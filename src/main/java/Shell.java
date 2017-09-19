import java.io.File;
import java.util.Scanner;

public class Shell {

    private static String currentDirectoryPath = System.getProperty("user.dir");
    private static Prompt prompt = new Prompt();
    private static DirectoryPath directoryPath = new DirectoryPath();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!"exit".equals(input)) {
            System.out.print(prompt + ">");
            input = scanner.nextLine();
            if ("pwd".equals(input))
                System.out.println(directoryPath);
            if ("dir".equals(input))
                System.out.println(directoryPath.getContentOf());
            String[] parts = input.split(" ");
            if ("cd".equals(parts[0]) && parts.length == 2)
                changeDirectoryTo(parts[1]);
            if ("prompt".equals((parts[0])) && parts.length == 2)
                prompt(parts[1]);
            if("tree".equals(input))
                System.out.println(directoryPath.getTree());//(new File(currentDirectoryPath));
        }
        System.out.println("Bye");
    }

    private static void prompt(String part) {
        if("reset".equals(part))
            prompt.reset();
        else if("$cwd".equals(part))
            prompt.setPrompt(directoryPath.toString());
        else
            prompt.setPrompt(part);
    }

    private static void changeDirectoryTo(String part) {
        if ("..".equals(part))
            directoryPath.changeToParent();
        else
            directoryPath.changeToSubdirectory(part);
    }

}
