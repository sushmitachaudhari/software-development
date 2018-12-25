package homework.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Sushmita Chaudhari
 */
class TestingHomeworkImplSqrTest {

    private TestingHomework testingHomework;

    @BeforeEach
    void setup()
    {
        testingHomework = new TestingHomeworkImpl();
    }

    @Test
    void boundaryMaxValueSqrTest()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(Integer.MAX_VALUE));
    }

    @Test
    void boundaryMaxValueSqrTest1()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(Integer.MAX_VALUE - 1));
    }

    @Test
    void boundaryMinValueSqrTest()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(Integer.MIN_VALUE));
    }

    @Test
    void boundaryMinValueSqrTest1()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(Integer.MIN_VALUE + 1));
    }

    /**
     * 46340 is the largest number whose square falls in the range of Integer.*/
    @Test
    void boundarySqrTest()
    {
        assertEquals(testingHomework.sqr(46340), Math.pow(46340, 2));
    }

    @Test
    void boundarySqrTest1()
    {
        assertEquals(testingHomework.sqr(46339), Math.pow(46339, 2));
    }

    //should throw exception
    @Test
    void boundarySqrTest2()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(46341));
    }

    @Test
    void negValueTest()
    {
        assertEquals(testingHomework.sqr(-1), Math.pow(-1, 2));
    }

    @Test
    void positiveZeroValueTest()
    {
        assertEquals(testingHomework.sqr(0), Math.pow(0, 2));
    }

    @Test
    void positiveValueTest()
    {
        assertEquals(testingHomework.sqr(1), Math.pow(1, 2));
    }

    //positive
    @Test
    void positiveValueTest1()
    {
        assertEquals(testingHomework.sqr(9), Math.pow(9, 2));
    }

    @Test
    void positiveOddValueTest()
    {
        assertEquals(testingHomework.sqr(47), Math.pow(47, 2));
    }

    @Test
    void positiveLargeOddValueTest()
    {
        assertEquals(testingHomework.sqr(1337), Math.pow(1337, 2));

    }

    @Test
    void positiveLargeOddValueTest1()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(47689));
    }

    
    @Test
    void positiveLargeOddValueTest2()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(-87654));
    }

    @Test
    void positiveLargeEvenValueTest()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(87654));
    }

    @Test
    void positiveLargeOddValueTest3()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(9087456));
    }


    @Test
    void positiveXLargeOddValueTest()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(1290765));
    }

    //negative
    @Test
    void negativeEvenValueTest()
    {

        assertEquals(testingHomework.sqr(-6), Math.pow(-6, 2));
    }

    @Test
    void negativeOddValueTest()
    {
        assertEquals(testingHomework.sqr(-19), Math.pow(-19, 2));
    }

    @Test
    void negativeOddValueTest1()
    {
        assertEquals(testingHomework.sqr(-139), Math.pow(-139, 2));
    }


    @Test
    void negativeEvenValueTest1()
    {
        assertEquals(testingHomework.sqr(-4568), Math.pow(-4568, 2));
    }

    
    @Test
    void negativeOddValueTest2()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(-1000145));
    }

    
    @Test
    void negativeLargeEvenValueTest()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(-101654));
    }

    
    @Test
    void negativeLargeOddValueTest()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(-6781243));
    }

    
    @Test
    void negativeXLargeEvenValueTest()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(-31245890));
    }

    
    @Test
    void negativeXLargeEvenValueTest1()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(-178914598));
    }

    //-ve and +ve
    
    @Test
    void negativeXLargeOddValueTest()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(-216459813));
    }

    
    

    
    @Test
    void negativeLargeOddValueTest1()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(-6789431));
    }

    
    @Test
    void negativeLargeOddValueTest2()
    {
        assertThrows(RuntimeException.class, () ->testingHomework.sqr(-500123));
    }


    @Test
    void negativeOddValueTest7()
    {
        assertEquals(testingHomework.sqr(-46340), Math.pow(-46340, 2));
    }


    @Test
    void negativeOddValueTest3()
    {
        assertEquals(testingHomework.sqr(-12901), Math.pow(12901, 2));
    }


    @Test
    void negativeOddValueTest4()
    {
        assertEquals(testingHomework.sqr(-7743), Math.pow(7743, 2));
    }

    @Test
    void negativeOddValueTest5()
    {
        assertEquals(testingHomework.sqr(-613), Math.pow(613, 2));
    }

    @Test
    void negativeOddValueTest6()
    {
        assertEquals(testingHomework.sqr(-613), Math.pow(613, 2));
    }

    @Test
    void negativeSmallEvenValueTest()
    {
        assertEquals(testingHomework.sqr(-78), Math.pow(78, 2));
    }

    @Test
    void negativeSmallEvenValueTest1()
    {
        assertEquals(testingHomework.sqr(-6), Math.pow(6, 2));
    }

    

}
