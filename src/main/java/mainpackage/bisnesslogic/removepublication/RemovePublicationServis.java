package mainpackage.bisnesslogic.removepublication;

import mainpackage.database.PublicationDataBase;
import mainpackage.domain.Publication;

import java.util.Optional;


public class RemovePublicationServis {

    private PublicationDataBase publicationDataBase;

    public RemovePublicationServis(PublicationDataBase publicationDataBase) {
        this.publicationDataBase = publicationDataBase;
    }

    public boolean removePublication(String title) {
        Optional<Publication> foundPublication = publicationDataBase.findByTitle(title);
        if (foundPublication.isPresent()) {
            Publication publication = foundPublication.get();
            publicationDataBase.remove(publication);
            return true;
        } else {
            return false;
        }
    }


}
