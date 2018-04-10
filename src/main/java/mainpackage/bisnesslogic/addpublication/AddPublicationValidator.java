package mainpackage.bisnesslogic.addpublication;

import mainpackage.database.PublicationDataBase;
import mainpackage.domain.Publication;
import mainpackage.bisnesslogic.Error;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddPublicationValidator {


    private PublicationDataBase publicationDataBase;

    public AddPublicationValidator(PublicationDataBase publicationDataBase) {
        this.publicationDataBase = publicationDataBase;
    }

    public List<Error> validate(String title, String description) {
        List<Error> errors = new ArrayList<>();
        validateTitle(title).ifPresent(errors::add);
        validateDuplicateTitle(title).ifPresent(errors::add);
        validateDescription(description).ifPresent(errors::add);
        return errors;
    }

    private Optional<Error> validateTitle(String title) {
        if (title == null || title.isEmpty()) {
            return Optional.of(new Error("title", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validateDescription(String description) {
        if (description == null || description.isEmpty()) {
            return Optional.of(new Error("description", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validateDuplicateTitle(String title) {
        if (title != null && !title.isEmpty()) {
            Optional<Publication> productOpt = publicationDataBase.findByTitle(title);
            if (productOpt.isPresent()) {
                return Optional.of(new Error("title", "Must not be repeated"));
            }
        }
        return Optional.empty();
    }




}
