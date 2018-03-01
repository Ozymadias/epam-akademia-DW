package directory;

import java.io.File;
import java.util.Arrays;
import java.util.Optional;

import static directory.FileType.*;

public class DirectoryPath {
    private File currentDirectoryPath;

    public DirectoryPath() {
        currentDirectoryPath = new File(System.getProperty("user.dir"));
    }

    @Override
    public String toString() {
        return currentDirectoryPath.toString();
    }

    public String getContentOf() {
        Optional<String> dirs = getString(DIR);
        return getString(FILE).map(file -> file + dirs.map(dir -> "\n" + dir).orElse(""))
                .orElse(dirs.orElse(""));
    }

    private Optional<String> getString(FileType prefix) {
        return Arrays.stream(currentDirectoryPath.listFiles())
                .filter(prefix.getPredicate())
                .map(file -> prefix + " " + file.getName())
                .reduce((a, b) -> a + "\n" + b);
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
