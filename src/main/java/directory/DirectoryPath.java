package directory;

import commands.IllegalCommandUsageException;

import java.io.File;
import java.util.Arrays;
import java.util.Optional;

import static directory.FileType.DIR;
import static directory.FileType.FILE;

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
        return getString(FILE)
                .map(file -> file + dirs.map(dir -> "\n" + dir).orElse(""))
                .orElse(dirs.orElse(""));
    }

    private Optional<String> getString(FileType prefix) {
        return Arrays.stream(currentDirectoryPath.listFiles())
                .filter(prefix.getPredicate())
                .map(file -> prefix + " " + file.getName())
                .reduce((a, b) -> a + "\n" + b);
    }

    public String getTree() {
        return getTree(currentDirectoryPath, "");
    }

    private String getTree(File file, String depth) {
        String tail = Arrays.stream(file.listFiles())
                .filter(File::isDirectory)
                .map(dir -> getTree(dir, depth + "-"))
                .reduce((a, b) -> a + b)
                .orElse("");
        return depth + file.getName() + "\n" + tail;
    }

    public void changeDirectoryTo(String part) throws IllegalCommandUsageException {
        if ("..".equals(part))
            changeToParent();
        else
            changeToSubdirectory(part);
    }

    private void changeToParent() {
        currentDirectoryPath = currentDirectoryPath.getParentFile();
    }

    private void changeToSubdirectory(String subdirectoryName) throws IllegalCommandUsageException {
        currentDirectoryPath = Arrays.stream(currentDirectoryPath.listFiles())
                .filter(File::isDirectory)
                .filter(file -> file.getName().equals(subdirectoryName))
                .findAny()
                .orElseThrow(() -> new IllegalCommandUsageException("No such subdirectory"));
    }

}
