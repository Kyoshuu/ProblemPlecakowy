import program.Backpack;
import program.Program;
import selectionMethods.GreatestWeightSelectionMethod;

public class Main {
    public static void main(String[] args) {
        // This part takes as 2 parameters from Command-Line arguments.
        // First one is path to file, second is size of backpack.
        Program program = new Program(args[0], Integer.parseInt(args[1]));
        // Next it fill backpack with selected algorithm
        program.fillBackpack(new GreatestWeightSelectionMethod());
        // Then it shows contents of backpack(items), its total weight
        // and its total value at selected PrintStream
        program.showBackpack(System.out);
    }
}
