public class Movie {
    private String name;
    private String description;
    private String type;
    private String typeDescription;

    public Movie (String name, String description, String type,
        String typeDescription) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.typeDescription = typeDescription;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

}