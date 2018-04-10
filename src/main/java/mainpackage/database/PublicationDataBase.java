package mainpackage.database;

import mainpackage.domain.Publication;


import java.util.List;
import java.util.Optional;

public interface PublicationDataBase {


    void add(Publication publication);

    Optional<Publication> findByTitle(String title);

    void remove(Publication publication);

    List<Publication> getAllProducts();


}
