package groceryStore.model;

public class Category {
    String id;
    String name;
    String quality;

    public Category() {
    }

    public Category(String id, String name, String quality) {
        this.id = id;
        this.name = name;
        this.quality = quality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quality='" + quality + '\'' +
                '}';
    }
}
