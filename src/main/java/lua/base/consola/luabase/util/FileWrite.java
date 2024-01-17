package lua.base.consola.luabase.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
@Component
public class FileWrite {

    /**
     * Writes a string to a file.
     *
     * @param resourceFileName the path of the file where the string will be written.
     * @param content the string content to write in the file.
     * @param append if true, the content will be appended to the file; if false, it will overwrite the file.
     * @throws IOException if an I/O error occurs.
     */
    public static void writeStringToFile(String relativePath, String content, boolean append) throws IOException {
        String fullPath = parentDirectoryPath + File.separator + relativePath;
        File file = new File(fullPath);
        File parentDir = file.getParentFile();

        // Creating the directory if it doesn't exist
        if (!parentDir.exists() && !parentDir.mkdirs()) {
            throw new IOException("Unable to create directory: " + parentDir);
        }

        // Creating the file if it doesn't exist
        if (!file.exists() && !file.createNewFile()) {
            throw new IOException("Unable to create file: " + file);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
            writer.write(content);
        }
    }

    private static String parentDirectoryPath;

    @Value("${file.parent.directory}")
    public void setParentDirectoryPath(String path) {
        FileWrite.parentDirectoryPath = path;
    }
}
