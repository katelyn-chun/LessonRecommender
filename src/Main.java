import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Lesson> lessons = FileProcessor.loadLessons("src/lessons.txt");

        System.out.println("All Categories:" + "\n" 
                            + "1. Resilience" + "\t"
                            + "2. Emotional Awareness" + "\t"
                            + "3. Cultural Awareness" + "\n"
                            + "4. Empathy" + "\t"
                            + "5. Civility" + "\t"
                            + "6. Emotional Intelligence" + "\n"
                            + "7. Anti-harrassment" + "\t"
                            + "8. Compassion" + "\t"
                            + "9. Kindness" + "\n"
                            + "10. Self Awareness" + "\t"
                            + "11. Social Responsibility" + "\t"
                            + "12. Prejudice" + "\n");
        Scanner input = new Scanner(System.in);
		System.out.println("Enter your preferred category by its number (e.g. 1, 2, 3, ..., 12): ");
		int prefCategory = input.nextInt();
        System.out.println("Your preferred category is: " + determinePreferredCategory(prefCategory));
        System.out.println("Enter your age group (e.g. 10, 20, 30, ...): ");
        int ageGroup = input.nextInt();
        System.out.println("Your age group is: " + ageGroup);
        System.out.println("All lessons: " + "\n" + printLessons(lessons));

        List<Integer> watchedIDList = new ArrayList<>();
        while (true) {
            System.out.println("\n--------------------------\n" 
            + "Input the lessons you have watched individually by ID (type '0' when complete): ");
            int watchedID = input.nextInt();
            if (watchedID == 0) break;
            System.out.println(findWatchedLesson(watchedID, lessons) + " was added to your watched list.");
            watchedIDList.add(watchedID);
        }
        
        System.out.println("You have watched the following lessons: ");
        for (int id : watchedIDList) {
            System.out.println(findWatchedLesson(id, lessons));
        }

        System.out.println("Based on your watched lessons, your preferred tags are: " 
            + findPreferredTags(watchedIDList, lessons));

        UserModel user = new UserModel(determinePreferredCategory(prefCategory), Integer.toString(ageGroup), findPreferredTags(watchedIDList, lessons), watchedIDList);

        List<Lesson> matches = LessonAlgorithm.findTopMatches(lessons, user, 3);
        System.out.println("\n--------------------------- \n" + "Top 3 Recommended Lessons:");
        matches.forEach(System.out::println);
        
        input.close();
    }

    public static String printLessons(List<Lesson> lessons) {
        StringBuilder sb = new StringBuilder();
        for (Lesson lesson : lessons) {
            sb.append(lesson.toString()).append("\n");
        }
        return sb.toString();
    }

    public static String determinePreferredCategory(int input) {
        return switch (input) {
            case 1 -> "Resilience";
            case 2 -> "Emotional Awareness";
            case 3 -> "Cultural Awareness";
            case 4 -> "Empathy";
            case 5 -> "Civility";
            case 6 -> "Emotional Intelligence";
            case 7 -> "Anti-harrassment";
            case 8 -> "Compassion";
            case 9 -> "Kindness";
            case 10 -> "Self Awareness";
            case 11 -> "Social Responsibility";
            case 12 -> "Prejudice";
            default -> "";
        };
    }
    
    public static String findWatchedLesson(int watchedID, List<Lesson> lessons) {
        for (Lesson lesson : lessons) {
            if (lesson.id == watchedID) {
                return lesson.toString();
            }
        }
        return "Lesson not found.";
    }

    public static List<String> findPreferredTags(List<Integer> watchedIDList, List<Lesson> lessons) {
        List<String> tags = new ArrayList<>();
        for (int id : watchedIDList) {
            for (Lesson lesson : lessons) {
                if (lesson.id == id) {
                    tags.addAll(lesson.tags);
                }
            }
        }
        return tags;
    }
}
