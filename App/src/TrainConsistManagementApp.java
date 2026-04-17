
import java.util.Arrays;

    public class TrainConsistManagementApp {



        static boolean binarySearch(String[] bogieIds, String key) {
            Arrays.sort(bogieIds);
            int low = 0, high = bogieIds.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                int cmp = key.compareTo(bogieIds[mid]);
                if (cmp == 0) return true;
                else if (cmp > 0) low = mid + 1;
                else high = mid - 1;
            }
            return false;
        }

        public static void main(String[] args) {
            System.out.println("==============================================");
            System.out.println(" UC19 - Binary Search for Bogie ID ");
            System.out.println("==============================================\n");

            String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

            String[] searchKeys = {"BG309", "BG999"};

            for (String key : searchKeys) {
                boolean found = binarySearch(bogieIds, key);
                if (found) System.out.println("Bogie " + key + " found in consist.");
                else System.out.println("Bogie " + key + " not found in consist.");
            }

            System.out.println("\nUC19 binary search completed...");
        }
    }
