package ba.edu.ibu.exams.finals.final1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {
    private static List<Job> jobs;

    @BeforeEach
    void loadJobs(){
        Final finalInstance = new Final("first-group.csv");
        jobs = finalInstance.getJobs();
    }

    @Test
    void ifValuesEmpty_ThrowAnCustomException(){
        assertThrows(InvalidCastException.class, () -> {
                new Final("mock-empty-values.csv");
        });
    }

    @Test
    void ifFileLoaded_assertMultipleConditions(){
        assertAll(
                () -> assertEquals("Data Architecture and Modeling", jobs.get(1).getCategory()),
                () -> assertTrue(jobs.size() == 9355)
        );
    }

    @Test
    void ifFileDoesNotExist_assertCauseIsFileNotFoundException(){
        try {
            Final finalInstance = new Final("non-existing-file");
        } catch (RuntimeException e){
            assertTrue(e.getCause() instanceof FileNotFoundException);
        }
    }
}