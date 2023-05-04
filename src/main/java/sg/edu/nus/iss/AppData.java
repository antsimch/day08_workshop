package sg.edu.nus.iss;

public class AppData {

    private String name;
    private String category;
    private String rating;
    
    public AppData(String name, String category, String rating) {
        this.name = name;
        this.category = category;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "AppData [name=" + name + ", category=" + category + ", rating=" + rating + "]";
    }
}
