import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase13TrainConsistMgmtTest {

    // Reuse the Bogie inner class structure via a local helper
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    private List<Bogie> bogies;

    @BeforeEach
    void setUp() {
        bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 55));
        bogies.add(new Bogie("First Class", 80));
        bogies.add(new Bogie("Goods", 40));
        bogies.add(new Bogie("Sleeper", 65));
    }

    // Helper: loop-based filter
    private List<Bogie> filterByLoop(List<Bogie> input, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : input) {
            if (b.capacity > threshold) {
                result.add(b);
            }
        }
        return result;
    }

    // Helper: stream-based filter
    private List<Bogie> filterByStream(List<Bogie> input, int threshold) {
        return input.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> result = filterByLoop(bogies, 60);
        // Capacities > 60: 72, 80, 65 → 3 bogies
        assertEquals(3, result.size());
        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> result = filterByStream(bogies, 60);
        // Capacities > 60: 72, 80, 65 → 3 bogies
        assertEquals(3, result.size());
        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> loopResult = filterByLoop(bogies, 60);
        List<Bogie> streamResult = filterByStream(bogies, 60);
        assertEquals(loopResult.size(), streamResult.size(),
                "Loop and Stream filtering should return the same number of results");
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        filterByLoop(bogies, 60);
        long end = System.nanoTime();
        long elapsed = end - start;

        assertTrue(elapsed > 0,
                "Elapsed time should be greater than zero");
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> largeBogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            largeBogies.add(new Bogie("Sleeper", 40 + (i % 80)));
        }

        List<Bogie> loopResult = filterByLoop(largeBogies, 60);
        List<Bogie> streamResult = filterByStream(largeBogies, 60);

        assertFalse(loopResult.isEmpty(), "Loop result should not be empty for large dataset");
        assertEquals(loopResult.size(), streamResult.size(),
                "Both methods should return same count for large dataset");
    }
}
