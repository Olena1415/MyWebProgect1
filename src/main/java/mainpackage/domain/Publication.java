package mainpackage.domain;

public class Publication {

    private Long id;
    private String title;
    private String description;

   public Publication(){}


   public Publication(String title, String description){

      // this.id=id;
       this.title=title;
       this.description=description;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publication publication = (Publication) o;

        if (id != null ? !id.equals(publication.id) : publication.id != null) return false;
        if (title != null ? !title.equals(publication.title) : publication.title != null) return false;
        return description != null ? description.equals(publication.description) : publication.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Publication){" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
