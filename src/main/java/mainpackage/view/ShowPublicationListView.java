package mainpackage.view;
import mainpackage.database.PublicationDataBase;
import mainpackage.domain.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class ShowPublicationListView implements View {
    @Autowired
    private PublicationDataBase database;

   /* public ShowPublicationListView(PublicationDataBase database) {
        this.database = database;
    }*/

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Print shopping list to console execution start!");
        for (Publication publication : database.getAllProducts()) {
            System.out.println(publication.getTitle() + "[" + publication.getDescription() + "]");
        }
        System.out.println("Print shopping list to console execution end!");
        System.out.println();
    }
}
