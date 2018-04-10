package mainpackage.view;

public class ProgrammExitView implements View {

    @Override
    public void execute() {
        System.out.println("Good by!");
        System.exit(0);
    }

}
