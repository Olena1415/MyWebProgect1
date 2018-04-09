package bisnesslogic.removepublication;
import java.util.Optional;
import domain.Publication;
import database.*;


public class RemovePublicationServis {

    private PublicationDataBase publicationDataBase;

    public RemovePublicationServis( PublicationDataBase publicationDataBase) {
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
