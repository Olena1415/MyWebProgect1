package database;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import domain.Publication;

public class PublicationInMemoriDatabase implements PublicationDataBase{

    private List<Publication> publications = new ArrayList<>();

    @Override
    public void add(Publication product) {
        publications.add(product);
    }

    @Override
    public Optional<Publication> findByTitle(String title) {
/*
        for (Product product : products) {
            if (product.getTitle().equals(title)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
*/
        return publications.stream()
                .filter(p -> p.getTitle().equals(title))
                .findFirst();
    }

    @Override
    public void remove(Publication product) {
        publications.remove(product);
    }

    @Override
    public List<Publication> getAllProducts() {
        List<Publication> allProducts = new ArrayList<>();
        allProducts.addAll(publications);
        return allProducts;
    }




}
