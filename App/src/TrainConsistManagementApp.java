import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC11 - Validate Train ID & Cargo Codes (Regex) ");
        System.out.println("========================================\n");

        Pattern trainIdPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoCodePattern = Pattern.compile("PET-[A-Z]{2}");

        String[] trainIds = {"TRN-1234", "TRAIN12", "TRN12A", "1234-TRN", "TRN-123", "TRN-12345", ""};
        String[] cargoCodes = {"PET-AB", "PET-ab", "PET123", "AB-PET", "PET-A", "PET-ABC", ""};

        System.out.println("--- Train ID Validation ---");
        for (String id : trainIds) {
            Matcher matcher = trainIdPattern.matcher(id);
            System.out.println("Train ID: \"" + id + "\" -> " + (matcher.matches() ? "Valid" : "Invalid"));
        }

        System.out.println("\n--- Cargo Code Validation ---");
        for (String code : cargoCodes) {
            Matcher matcher = cargoCodePattern.matcher(code);
            System.out.println("Cargo Code: \"" + code + "\" -> " + (matcher.matches() ? "Valid" : "Invalid"));
        }

        System.out.println("\nUC11 regex validation completed...");
    }
}