import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("========================================\n");

        // Valid train formation
        List<GoodsBogie> validTrain = new ArrayList<>();
        validTrain.add(new GoodsBogie("Cylindrical", "Petroleum"));
        validTrain.add(new GoodsBogie("Cylindrical", "Petroleum"));
        validTrain.add(new GoodsBogie("Open", "Coal"));
        validTrain.add(new GoodsBogie("Box", "Grain"));

        boolean isValidSafe = validTrain.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        System.out.println("Valid Train Formation:");
        for (GoodsBogie b : validTrain) {
            System.out.println("  Type: " + b.type + " | Cargo: " + b.cargo);
        }
        System.out.println("Safety Compliant: " + isValidSafe);

        // Invalid train formation
        List<GoodsBogie> invalidTrain = new ArrayList<>();
        invalidTrain.add(new GoodsBogie("Cylindrical", "Petroleum"));
        invalidTrain.add(new GoodsBogie("Cylindrical", "Coal"));
        invalidTrain.add(new GoodsBogie("Open", "Grain"));

        boolean isInvalidSafe = invalidTrain.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        System.out.println("\nInvalid Train Formation:");
        for (GoodsBogie b : invalidTrain) {
            System.out.println("  Type: " + b.type + " | Cargo: " + b.cargo);
        }
        System.out.println("Safety Compliant: " + isInvalidSafe);

        // Empty list
        List<GoodsBogie> emptyTrain = new ArrayList<>();
        boolean isEmptySafe = emptyTrain.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        System.out.println("\nEmpty Train Formation:");
        System.out.println("Safety Compliant: " + isEmptySafe);

        System.out.println("\nUC12 safety compliance check completed...");
    }
}