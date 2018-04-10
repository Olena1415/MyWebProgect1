package mainpackage.view;
import org.springframework.stereotype.Component;



@Component
public class ProgrammExitView implements View {

    @Override
    public void execute() {
        System.out.println("Good by!");
        System.exit(0);
    }

}
