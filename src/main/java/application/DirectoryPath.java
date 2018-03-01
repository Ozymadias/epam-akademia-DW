package application;

import java.io.File;

public class DirectoryPath {
    private File currentDirectoryPath;

    DirectoryPath() {
        currentDirectoryPath = new File(System.getProperty("user.dir"));
    }

    @Override
    public String toString() {
        return currentDirectoryPath.toString();
    }

    public String getContentOf() {
        StringBuilder stringBuilder = new StringBuilder();
        for (File file : currentDirectoryPath.listFiles()) {
            if (file.isFile())
                stringBuilder.append("FILE ").append(file.getName()).append("\n");
            if (file.isDirectory())
                stringBuilder.append("DIR  ").append(file.getName()).append("\n");
        }
        return stringBuilder.toString();
    }

    public String getTree() {
        StringBuilder stringBuilder = new StringBuilder(currentDirectoryPath.getName());
        stringBuilder.append("\n");
        for (File file : currentDirectoryPath.listFiles())
            if (file.isDirectory())
                stringBuilder.append(getTree(file, "-"));
        return stringBuilder.toString();
    }

    private String getTree(File file, String depth) {
        StringBuilder stringBuilder = new StringBuilder(depth);
        stringBuilder.append(file.getName()).append("\n");
        for (File f : file.listFiles())
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

    private void changeToParent() {
        currentDirectoryPath = currentDirectoryPath.getParentFile();
    }

    private void changeToSubdirectory(String subdirectoryName) {
        for (File file : currentDirectoryPath.listFiles())
            if (file.getName().equals(subdirectoryName))
                currentDirectoryPath = file;
        //error Handling
    }
}
