package database;

import java.util.List;
import java.util.Optional;
import domain.Publication;

public interface PublicationDataBase {


    void add(Publication publication);

    Optional<Publication> findByTitle(String title);

    void remove(Publication publication);

    List<Publication> getAllProducts();



}
