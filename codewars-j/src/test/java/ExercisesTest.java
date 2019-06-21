import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExercisesTest {

    // @Test
    // void camelCase() {
    //     assertEquals("CamelCaseWord",
    //             Exercises.camelCase("camel case word"));
    //
    //     assertEquals("HelloCase",
    //             Exercises.camelCase("hello case"));
    // }

    @Test
    public void highTests() {
        assertEquals("taxi",
                Exercises.high("man i need a taxi up to ubud"));
        assertEquals("volcano",
                Exercises.high("what time are we climbing up to the volcano"));
        assertEquals("semynak",
                Exercises.high("take me to semynak"));
    }
}