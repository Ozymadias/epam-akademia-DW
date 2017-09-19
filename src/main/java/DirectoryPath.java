import java.io.File;

public class DirectoryPath {
    private static String currentDirectoryPath = System.getProperty("user.dir");

    @Override
    public String toString() {
        return currentDirectoryPath;
    }

    public String getContentOf() {
        File currentDirectory = new File(currentDirectoryPath);
        File[] files = currentDirectory.listFiles();
        StringBuilder stringBuilder = new StringBuilder();
        for (File file : files) {
            if (file.isFile())
                stringBuilder.append("FILE ").append(file);
            if (file.isDirectory())
                stringBuilder.append("DIR  ").append(file);
        }
        return stringBuilder.toString();
    }

    private void changeToParent() {
        File currentDirectory = new File(currentDirectoryPath);
        currentDirectoryPath = currentDirectory.getParent();
    }

    private void changeToSubdirectory(String subdirectoryName) {
        File currentDirectory = new File(currentDirectoryPath);
        File[] files = currentDirectory.listFiles();
        for (File file : files)
            if (file.getName().equals(subdirectoryName))
                currentDirectoryPath = file.getPath();
        //error Handling
    }

    public String getTree() {
        File currentDirectory = new File(currentDirectoryPath);
        StringBuilder stringBuilder = new StringBuilder(currentDirectory.getName());
        stringBuilder.append("\n");
        File[] files = currentDirectory.listFiles();
        for (File file : files)
            if (file.isDirectory())
                stringBuilder.append(getTree(file, "-"));
        return stringBuilder.toString();
    }

    private String getTree(File file, String depth) {
        StringBuilder stringBuilder = new StringBuilder(depth);
        stringBuilder.append(file.getName()).append("\n");
        File[] files = file.listFiles();
        for (File f : files)
            if (f.isDirectory())
                stringBuilder.append(getTree(f, depth + "-"));
        return stringBuilder.toString();
    }

    public void changeDirectoryTo(String part) {
        if ("..".equals(part))
            changeToParent();
        else
            changeToSubdirectory(part);
    }
}
