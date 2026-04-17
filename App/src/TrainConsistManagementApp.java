public class TrainConsistManagementApp {

    static boolean linearSearch(String[] bogieIds, String key) {
        for (String id : bogieIds) {
            if (id.equals(key)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC18 - Linear Search for Bogie ID ");
        System.out.println("==============================================\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String[] searchKeys = {"BG309", "BG999"};

        for (String key : searchKeys) {
            boolean found = linearSearch(bogieIds, key);
            if (found) System.out.println("Bogie " + key + " found in consist.");
            else System.out.println("Bogie " + key + " not found in consist.");
        }

        System.out.println("\nUC18 linear search completed...");
    }
}