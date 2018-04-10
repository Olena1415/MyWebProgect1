package mainpackage.view;

import mainpackage.bisnesslogic.removepublication.RemovePublicationServis;
import mainpackage.database.PublicationDataBase;

import java.util.Scanner;

public class RemovePublicationView implements View {



    private RemovePublicationServis removePublicationServis;

    public RemovePublicationView(PublicationDataBase database) {
        this.removePublicationServis = new RemovePublicationServis(database);
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Remove product from list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product title:");
        final String title = sc.nextLine();

        boolean isRemoved = removePublicationServis.removePublication(title);


        if (isRemoved) {
            System.out.println("Product with title " + title + " was found and will be removed from list!");
        } else {
            System.out.println("Product with title " + title + " not found and not be removed from list!");
        }
        System.out.println("Remove product from list execution end!");
        System.out.println();
    }



}
