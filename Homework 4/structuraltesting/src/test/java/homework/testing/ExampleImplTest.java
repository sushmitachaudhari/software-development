package homework.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Sushmita Chaudhari
 */
class ExampleImplTest {
    private ExampleImpl example;

    @BeforeEach
    void setUp() {
        example = new ExampleImpl();
    }

    @Test
    void exampleWithMultipleSpaceTest() {
        assertEquals(example.example("test    test"), 1);
    }

    @Test
    void exampleWithNoSpaceTest() {
        assertEquals(example.example("aa"), 0);
    }

    @Test
    void exampleWithSingleSpaceTest() {

        assertEquals(example.example("a b"), 0);


    }
    @Test
    void exampleWithSingleSpaceTest1() {
        assertEquals(example.example(" "), 0);

    }


    @Test
    void exampleWithDoubleSpaceTest() {
        assertEquals(example.example("  "), 0);

    }

    @Test
    void exampleWithMultipleSpaceTest1() {
        assertEquals(example.example("                             "), 0);
    }


    @Test
    void exampleWithSpaceAfterEachCharTest() {
        assertEquals(example.example("b   c  d   e"), 3);
    }


    @Test
    void exampleWithMultipleSpaceAroundAChar() {
        assertEquals(example.example("   b "), 1);

    }

    @Test
    void exampleWithMultipleSpaceAroundChars() {
        assertEquals(example.example("   b c  d"), 2);
    }



    @Test
    void exampleWithMultipleSpaceAroundChars1() {
        assertEquals(example.example("   Hello   ,    there   ! How are you? This    is a test   ."), 6);
    }


    @Test
    void exampleWithSingleSpaceAroundWords() {
        assertEquals(example.example(" Hello , there ! How are you? This is a test ."), 0);
    }

    @Test
    void exampleWithInvalidInputShouldThrowException() {

        assertThrows(  RuntimeException.class, ()->example.example(null));

    }
}