package directory;

import java.io.File;
import java.util.function.Predicate;

public enum FileType {
    DIR, FILE;

    private Predicate<File> predicate;

    static {
        DIR.predicate = File::isDirectory;
        FILE.predicate = File::isFile;
    }

    public Predicate<File> getPredicate() {
        return predicate;
    }
}
