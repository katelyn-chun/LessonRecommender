import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Lesson> lessons = FileProcessor.loadLessons("src/lessons.txt");

        UserModel user = new UserModel("Resilience", "20",
            List.of("empathy", "problem-solving", "teamwork", "communication")
        );

        // List<Lesson> matches = LessonAlgorithm.findTopMatches(lessons, user, 3);
        System.out.println("Lessons:");
        for (Lesson lesson : lessons) {
            System.out.println(lesson);
        }
        // matches.forEach(System.out::println);
    }
}
