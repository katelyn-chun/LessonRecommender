import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FileProcessor {
    public static List<Lesson> loadLessons(String filename) throws IOException {
        List<Lesson> lessons = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get("src/lessons.txt"));
        for (String line : lines) {
            if (line.startsWith("ID")) continue;
            String[] parts = line.split("\\|");
            String[] tagArray = parts[4].split(",");
            lessons.add(new Lesson(
                Integer.parseInt(parts[0]), parts[1], parts[2], parts[3],
                Arrays.asList(tagArray)
            ));
        }
        return lessons;
    }
}
