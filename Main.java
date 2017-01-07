import program.Program;
import selectionMethods.GreatestWeightSelectionMethod;

public class Main {
    public static void main(String[] args) {
        Program program = new Program(args[0], Integer.parseInt(args[1]));
        program.fillBackpack(new GreatestWeightSelectionMethod());
        program.showBackpack(System.out);
    }
}
