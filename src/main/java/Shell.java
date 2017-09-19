import java.io.File;
import java.util.Scanner;

public class Shell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String currentDirectoryPath = System.getProperty("user.dir");
        while(!"exit".equals(input)) {
            System.out.print("$>");
            input = scanner.next();
            if("dir".equals(input))
                displayContentOf(currentDirectoryPath);
        }
        System.out.println("Bye");
    }

    private static void displayContentOf(String currentDirectoryPath) {
        File currentDirectory = new File(currentDirectoryPath);
        File[] files = currentDirectory.listFiles();
        for (File file:files) {
            if(file.isFile())
                System.out.println("FILE " + file);
            if(file.isDirectory())
                System.out.println("DIR  " + file);
        }
    }
}
