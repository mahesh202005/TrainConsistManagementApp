import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC10 - Count Total Seats in Train (reduce) ");
        System.out.println("========================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));

        System.out.println("Bogie Capacity Details:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity + " seats");
        }

        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats + " seats");

        System.out.println("\nOriginal List Size (Unchanged): " + bogies.size());

        System.out.println("\nUC10 seat aggregation completed...");
    }
}