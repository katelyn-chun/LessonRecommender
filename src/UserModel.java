import java.util.List;

public class UserModel {
    public String preferredCategory;
    public String ageGroup;
    public List<String> preferredTags;

    public UserModel(String preferredCategory, String ageGroup, List<String> preferredTags) {
        this.preferredCategory = preferredCategory;
        this.ageGroup = ageGroup;
        this.preferredTags = preferredTags;
    }
}