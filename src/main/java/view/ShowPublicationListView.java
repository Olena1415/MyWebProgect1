package view;
import database.PublicationDataBase;
import domain.Publication;


public class ShowPublicationListView implements View{

    private PublicationDataBase database;

    public ShowPublicationListView(PublicationDataBase database) {
        this.database = database;
    }

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
