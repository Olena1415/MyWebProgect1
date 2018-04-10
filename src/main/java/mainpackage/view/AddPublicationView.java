package mainpackage.view;

import mainpackage.bisnesslogic.addpublication.AddPublicationResponse;
import mainpackage.bisnesslogic.addpublication.AddPublicationServiss;
import mainpackage.bisnesslogic.addpublication.AddPublicationValidator;
import mainpackage.database.PublicationDataBase;

import java.util.Scanner;

public class AddPublicationView implements View {

    private AddPublicationServiss addPublicationServiss;

    public AddPublicationView(PublicationDataBase database) {
        AddPublicationValidator validator = new AddPublicationValidator(database);
        this.addPublicationServiss = new AddPublicationServiss(database, validator);
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Add product to list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product title:");
        String title = sc.nextLine();
        System.out.print("Enter product description:");
        String description = sc.nextLine();

        AddPublicationResponse response = addPublicationServiss.addPublication(title, description);
        if (response.isSuccess()) {
            System.out.println("Product successfully added to list!");
            System.out.println();
        } else {
            response.getErrors().forEach(error -> {
                System.out.println("Error field = " + error.getField());
                System.out.println("Error message = " + error.getErrorMessage());
            });
            System.out.println();
        }
    }


}
