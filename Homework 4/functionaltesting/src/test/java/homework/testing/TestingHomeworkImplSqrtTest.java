package homework.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Sushmita Chaudhari
 */
class TestingHomeworkImplSqrtTest {
    private TestingHomework testingHomework;

    @BeforeEach
    void setup()
    {
        testingHomework = new TestingHomeworkImpl();
    }

    @Test
    void boundaryMaxValueSqrtTest()
    {
        assertEquals(testingHomework.sqrt(Integer.MAX_VALUE), Math.sqrt(Integer.MAX_VALUE), 0.001);
    }

    @Test
    void boundaryMinValueSqrtTest()
    {
        assertThrows(RuntimeException.class, ()-> testingHomework.sqrt(Integer.MIN_VALUE));
    }

    @Test
    void boundaryMinValuePlusOneSqrtTest()
    {
        assertThrows(RuntimeException.class, ()-> testingHomework.sqrt(Integer.MIN_VALUE + 1));

    }

    @Test
    void boundaryMaxValueMinusOneSqrtTest() {
        assertEquals(testingHomework.sqrt(Integer.MAX_VALUE - 1),
                Math.sqrt(Integer.MAX_VALUE - 1), 0.001);
    }

    @Test
    void boundaryZeroSqrtTest() { assertEquals(testingHomework.sqrt(0), 0); }

    @Test
    void boundaryMinusOneSqrtTest() {
        assertThrows(RuntimeException.class, () -> testingHomework.sqrt(-1));
    }

    @Test
    void boundaryOneSqrtTest()
    {
        assertEquals(testingHomework.sqrt(1), 1);
    }

    //positive
    @Test
    void positiveValueEvenTest() { assertEquals(testingHomework.sqrt(4), Math.sqrt(4), 0.001); }

    @Test
    void positiveValueOddTest() { assertEquals(testingHomework.sqrt(7), Math.sqrt(7), 0.001); }

    @Test
    void positiveValueOddTest1()
    {
        assertEquals(testingHomework.sqrt(21), Math.sqrt(21) , 0.001);
    }

    @Test
    void positiveValueOddTest2()
    {
        assertEquals(testingHomework.sqrt(39), Math.sqrt(39) , 0.001);
    }

    @Test
    void positiveValueOddTest3()
    {
        assertEquals(testingHomework.sqrt(57), Math.sqrt(57), 0.001);
    }

    @Test
    void positiveValueLargeTest()
    {
        assertEquals(testingHomework.sqrt(25431), Math.sqrt(25431), 0.001);
    }

    @Test
    void positiveValueLargeTest1()
    {
        assertEquals(testingHomework.sqrt(37361), Math.sqrt(37361), 0.001);
    }

    @Test
    void positiveValueLargeTest2()
    {
        assertEquals(testingHomework.sqrt(52541), Math.sqrt(52541), 0.001);
    }

    @Test
    void positiveValueLargeTest3()
    {
        assertEquals(testingHomework.sqrt(101345), Math.sqrt(101345), 0.001);
    }

    @Test
    void positiveValueLargeTest4()
    {
        assertEquals(testingHomework.sqrt(291570), Math.sqrt(291569), 0.001);
    }

    @Test
    void positiveValueXLargeTest1()
    {
        assertEquals(testingHomework.sqrt(20004567), Math.sqrt(20004567), 0.001);
    }

    @Test
    void positiveValueXLargeTest2() { assertEquals(testingHomework.sqrt(300000000), Math.sqrt(300000000), 0.001); }

    //negative
    @Test
    void negativeValueOddTest() {
        assertThrows(RuntimeException.class, ()-> testingHomework.sqrt(-25));

         }

    @Test
    void negativeValueOddTest1()
    {
        assertThrows(RuntimeException.class, ()-> testingHomework.sqrt(-345));
    }

    @Test
    void negativeValueEvenTest1() {
        assertThrows(RuntimeException.class, ()-> testingHomework.sqrt(-4344));
       }

    @Test
    void negativeLargeValueTest()
    {
        assertThrows(RuntimeException.class, ()-> testingHomework.sqrt(-56345));
    }

    @Test
    void negativeLargeValueTest1() {
        assertThrows(RuntimeException.class, () -> testingHomework.sqrt(-101345));
    }

    @Test
    void negativeLargeValueTest2()
    {
        assertThrows(RuntimeException.class, () -> testingHomework.sqrt(-3467345));
    }

    @Test
    void negativeXLargeValueTest()
    {
        assertThrows(RuntimeException.class, () -> testingHomework.sqrt(-10099345));
    }

    @Test
    void negativeXLargeValueTest1()
    {
        assertThrows(RuntimeException.class, () -> testingHomework.sqrt(-238912345));
    }

    @Test
    void negativeXLargeValueTest2()
    {
        assertThrows(RuntimeException.class, () -> testingHomework.sqrt(-789346345));
    }
}