package axiomq.com.starwars.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class FileUtil {

    private FileUtil(){

    }

    public static final String folderPath = "/upload";
    public static final Path filePath = Paths.get(folderPath);
}
