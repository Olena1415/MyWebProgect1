package mainpackage.database;

import mainpackage.domain.Publication;

import java.util.List;
import java.util.Optional;

public class MainTestBaza {

    public static void main(String[] args) {

        PublicationRealDataBase prd = new PublicationRealDataBase();
        // Publication publication =new Publication( "basya","gav");
        //prd.add(publication);
             String s = "basya";
        Optional<Publication> optional = prd.findByTitle(s);
          System.out.println(optional.get().getDescription());

         prd.remove(optional.get());



        List<Publication> list =prd.getAllProducts();
        for(Publication p:list){
            System.out.println(p.getTitle()+" " +p.getDescription());
        }




    }
}
