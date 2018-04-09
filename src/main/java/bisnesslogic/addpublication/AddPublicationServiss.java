package bisnesslogic.addpublication;
import java.util.List;
import bisnesslogic.Error;
import database.PublicationDataBase;
import domain.Publication;

public class AddPublicationServiss {

    private PublicationDataBase publicationDataBase;
    private AddPublicationValidator addPublicationValidator;

    public AddPublicationServiss(PublicationDataBase publicationDataBase,
                                 AddPublicationValidator addPublicationValidator) {
        this.publicationDataBase = publicationDataBase;
        this.addPublicationValidator = addPublicationValidator;
    }

    public AddPublicationResponse addPublication(String title,
                                         String description) {
        List<Error> validationErrors = addPublicationValidator.validate(title, description);
        if (!validationErrors.isEmpty()) {
            return new AddPublicationResponse(false, validationErrors);
        }

        Publication publication = new Publication();
        publication.setTitle(title);
        publication.setDescription(description);
        publicationDataBase.add(publication);

        return new AddPublicationResponse(true, null);
    }





}
