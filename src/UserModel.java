import java.util.List;

public class UserModel {
    public String preferredCategory;
    public String ageGroup;
    public List<String> preferredTags;
    public List<Integer> lessonsWatched;

    public UserModel(String preferredCategory, String ageGroup, List<String> preferredTags, List<Integer> lessonsWatched) {
        this.preferredCategory = preferredCategory;
        this.ageGroup = ageGroup;
        this.preferredTags = preferredTags;
        this.lessonsWatched = lessonsWatched;
    }

    public String toString() {
        return String.format("UserModel(Preferred Category: %s, Age Group: %s, Preferred Tags: %s, Lessons Watched: %s)", 
            preferredCategory, ageGroup, preferredTags, lessonsWatched);
    }
}