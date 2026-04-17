public class TrainConsistManagementApp {

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC16 - Sort Passenger Bogies by Capacity ");
        System.out.println("==============================================\n");

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.print("Before Sorting: ");
        for (int c : capacities) System.out.print(c + " ");
        System.out.println();

        bubbleSort(capacities);

        System.out.print("After Sorting:  ");
        for (int c : capacities) System.out.print(c + " ");
        System.out.println();

        System.out.println("\nUC16 sorting completed...");
    }