import java.util.List;

public class LessonAlgorithm {
    
    public static double matchScore(Lesson lesson, UserModel pref) {
        double score = 0;
        if (lesson.category.equalsIgnoreCase(pref.preferredCategory)) score += 1;
        if (lesson.ageGroup.equalsIgnoreCase(pref.ageGroup)) score += 1;

        return score;
    }
    
}