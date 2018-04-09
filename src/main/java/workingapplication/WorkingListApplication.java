package workingapplication;
import view.*;
import database.PublicationDataBase;
import database.PublicationInMemoriDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WorkingListApplication {


    public static void main(String[] args) {
        // Use cases:
        // 1. Add publication to list
        // 2. Remove publication from list
        // 3. Print all list to console
        // 4. Exit

        PublicationDataBase database = new PublicationInMemoriDatabase();

        View addPublicationView = new AddPublicationView(database);
        View removePublicationView = new RemovePublicationView(database);
        View showPublicationView = new ShowPublicationListView(database);
        View programExitView = new ProgrammExitView();

        Map<Integer, View> actionMap = new HashMap<>();
        actionMap.put(1, addPublicationView);
        actionMap.put(2, removePublicationView);
        actionMap.put(3, showPublicationView);
        actionMap.put(4, programExitView);

        while (true) {
            printProgramMenu();
            int menuItem = getFromUserMenuItemToExecute();
            View view = actionMap.get(menuItem);
            view.execute();
        }
    }


    private static void printProgramMenu() {
        System.out.println("Program Menu:");
        System.out.println("1. Add publication to list");
        System.out.println("2. Remove publication from list");
        System.out.println("3. Print list to console");
        System.out.println("4. Exit");
    }


    private static int getFromUserMenuItemToExecute() {
        System.out.print("Please enter menu item number to execute:");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }





}
