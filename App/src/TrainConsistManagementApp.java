public class TrainConsistManagementApp {

    static boolean searchBogie(String[] bogieIds, String key) {
        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in the train consist");
        }
        for (String id : bogieIds) {
            if (id.equals(key)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC20 - Exception Handling During Search ");
        System.out.println("==============================================\n");

        // Valid search
        try {
            String[] bogieIds = {"BG101", "BG205", "BG309"};
            boolean found = searchBogie(bogieIds, "BG205");
            System.out.println("Search result for BG205: " + (found ? "Found" : "Not Found"));
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Empty array search
        try {
            boolean found = searchBogie(new String[]{}, "BG101");
            System.out.println("Search result for BG101: " + (found ? "Found" : "Not Found"));
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC20 exception handling completed...");
    }
}