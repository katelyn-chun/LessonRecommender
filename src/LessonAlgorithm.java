import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LessonAlgorithm {
    
    public static double matchScore(Lesson lesson, UserModel user) {
        
        if (user.lessonsWatched.contains(lesson.id)) {
            return -2;
        }

        double score = 0;

        if (lesson.category.equalsIgnoreCase(user.preferredCategory)) score += 1;
        if (lesson.ageGroup.equalsIgnoreCase(user.ageGroup)) score += 0.5;

        for (String tag : lesson.tags) {
            if (user.preferredTags.contains(tag)) score += 0.5;
        }

        return score;
    }

    public static List<Lesson> findTopMatches(List<Lesson> lessons, UserModel user, int topNum) {
        List<LessonScore> scoredLessons = new ArrayList<>();

        for (Lesson lesson : lessons) {
            double score = matchScore(lesson, user);
            scoredLessons.add(new LessonScore(lesson, score));
        }

        scoredLessons.sort((a, b) -> Double.compare(b.score, a.score));
        List<Lesson> result = new ArrayList<>();

        for (int i = 0; i < Math.min(topNum, scoredLessons.size()); i++) {
            result.add(scoredLessons.get(i).lesson);
        }
        
        return result;
    }

    private static class LessonScore {
        Lesson lesson;
        double score;
        LessonScore(Lesson lesson, double score) {
            this.lesson = lesson;
            this.score = score;
        }
    }
}