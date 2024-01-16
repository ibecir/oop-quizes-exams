package ba.edu.ibu.exams.finals.final2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PopulationTest {
    private static List<Population> populations;

    @BeforeEach
    void loadPopulations() {
        SecondFinal finalInstance = new SecondFinal("second-group.csv");
        populations = finalInstance.getPopulations();
    }

    @Test
    void ifValuesEmpty_ThrowAnCustomException() {
        assertThrows(WrongFormatException.class, () -> {
            new SecondFinal("mock-empty-values.csv");
        });
    }

    @Test
    void ifFileLoaded_assertMultipleConditions() {
        assertAll(
                () -> assertEquals("Switzerland", populations.get(100).getCountry()),
                () -> assertTrue(populations.size() == 234)
        );
    }

    @Test
    void ifFileDoesNotExist_assertCauseIsFileNotFoundException() {
        try {
            SecondFinal finalInstance = new SecondFinal("non-existing-file");
        } catch (RuntimeException e) {
            System.out.println(e.getCause());
            assertTrue(e.getCause() instanceof FileNotFoundException);
        }
    }
}