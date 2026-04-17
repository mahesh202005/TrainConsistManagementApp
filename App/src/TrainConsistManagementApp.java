public class TrainConsistManagementApp {

    // ---- CUSTOM RUNTIME EXCEPTION ----
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie model
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
            this.cargo = null;
        }

        void assignCargo(String cargoType) {
            try {
                if (shape.equalsIgnoreCase("Rectangular") && cargoType.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe assignment: Petroleum cannot be assigned to Rectangular bogie");
                }
                this.cargo = cargoType;
                System.out.println("Cargo assigned: " + cargoType + " -> " + shape + " bogie");
            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Cargo validation check completed.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC15 - Safe Cargo Assignment ");
        System.out.println("==============================================\n");

        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        cylindrical.assignCargo("Petroleum");

        System.out.println();

        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        rectangular.assignCargo("Petroleum");

        System.out.println("\nUC15 exception handling completed...");
    }
}