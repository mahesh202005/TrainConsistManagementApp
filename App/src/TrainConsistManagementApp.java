import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp{

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC5 - Preserve Insertion Order of Bogies ");
        System.out.println("========================================\n");

        Set<String> trainFormation = new LinkedHashSet<>();

        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");
        trainFormation.add("Sleeper"); // Duplicate - ignored

        System.out.println("Train Formation (Insertion Order Preserved):");
        System.out.println(trainFormation);

        System.out.println("\nNote:");
        System.out.println("Duplicate 'Sleeper' was ignored by LinkedHashSet.");

        System.out.println("\nUC5 insertion order validation completed...");
    }
}