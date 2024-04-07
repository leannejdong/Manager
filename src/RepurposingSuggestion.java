// RepurposingSuggestion.java
public class RepurposingSuggestion {
    private String title;
    private String imageLocation;
    private String webLink;
    private String primaryMaterials;
    private String constructionHints;

    // Constructor
    public RepurposingSuggestion(String title, String imageLocation, String webLink, String primaryMaterials) {
        this.title = title;
        this.imageLocation = imageLocation;
        this.webLink = webLink;
        this.primaryMaterials = primaryMaterials;
        //this.constructionHints = constructionHints;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public String getWebLink() {
        return webLink;
    }

    public String getPrimaryMaterials() {
        return primaryMaterials;
    }

    public String getConstructionHints() {
        return constructionHints;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }

    public void setPrimaryMaterials(String primaryMaterials) {
        this.primaryMaterials = primaryMaterials;
    }

    public void setConstructionHints(String constructionHints) {
        this.constructionHints = constructionHints;
    }
}