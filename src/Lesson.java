import java.util.List;

public class Lesson {
    public int id;
    public String title;
    public String category; // ex: "Empathy", "Resilience"
    public String ageGroup; // ex: "12-14"
    public List<String> tags;

    public Lesson(int id, String title, String category, String ageGroup, List<String> tags) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.ageGroup = ageGroup;
        this.tags = tags;
    }

    public String toString() {
        return String.format("[%s] %s (Category: %s, Age Range: %s, Tags: %s)", id, title, category, ageGroup, tags);
    }
}