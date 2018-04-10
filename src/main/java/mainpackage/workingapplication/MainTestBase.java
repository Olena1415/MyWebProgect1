package mainpackage.workingapplication;

import mainpackage.configs.SpringAppConfig;
import mainpackage.database.PublicationDataBase;
import mainpackage.database.PublicationRealDataBase;
import mainpackage.view.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MainTestBase {


    public static void main(String[] args) {
        // Use cases:
        // 1. Add publication to list
        // 2. Remove publication from list
        // 3. Print all list publication to console
        // 4. Exit

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);



        Map<Integer, View> actionMap = new HashMap<>();
        actionMap.put(1, applicationContext.getBean(AddPublicationView.class));
        actionMap.put(2, applicationContext.getBean(RemovePublicationView.class));
        actionMap.put(3, applicationContext.getBean(ShowPublicationListView.class));
        actionMap.put(4, applicationContext.getBean(ProgrammExitView.class));



       /* PublicationDataBase database = new PublicationRealDataBase();

        View addPublicationView = new AddPublicationView(database);
        View removePublicationView = new RemovePublicationView(database);
        View showPublicationView = new ShowPublicationListView(database);
        View programExitView = new ProgrammExitView();*


        Map<Integer, View> actionMap = new HashMap<>();
        actionMap.put(1, addPublicationView);
        actionMap.put(2, removePublicationView);
        actionMap.put(3, showPublicationView);
        actionMap.put(4, programExitView);*/

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
