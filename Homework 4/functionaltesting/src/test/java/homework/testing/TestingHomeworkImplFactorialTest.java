package homework.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Sushmita Chaudhari
 */
class TestingHomeworkImplFactorialTest {

    private TestingHomework testingHomework;

    @BeforeEach
    void setup()
    {
        testingHomework = new TestingHomeworkImpl();
    }


    @Test
    void boundaryFactorialTest()
    {
        assertThrows(RuntimeException.class, ()->testingHomework.factorial(Integer.MAX_VALUE ));
    }

    @Test
    void boundaryFactorialTest1()
    {
        assertThrows(RuntimeException.class, ()->testingHomework.factorial(Integer.MAX_VALUE - 1));
    }

    @Test
    void boundaryFactorialTest2()
    {
        assertThrows(RuntimeException.class,()->testingHomework.factorial(Integer.MIN_VALUE));
    }

    @Test
    void boundaryFactorialTest3()
    {
        assertThrows(RuntimeException.class,()->
                testingHomework.factorial(Integer.MIN_VALUE + 1));
    }

    @Test
    void boundaryFactorialTest4()
    {
        assertThrows(RuntimeException.class,()->testingHomework.factorial(-1));
    }

    @Test
    void boundaryFactorialTest5()
    {
        assertThrows( RuntimeException.class, ()->testingHomework.factorial(13));

    }

    @Test
    void boundaryZeroFactorialTest()
    {
        assertEquals(testingHomework.factorial(0),1);
    }

    @Test
    void boundaryOneFactorialTest()
    {
        assertEquals(testingHomework.factorial(1),1);
    }

    //positive tests
    @Test
    void factorialEvenTest()
    {
        assertEquals(testingHomework.factorial(2),2);
    }

    @Test
    void testFactorial9()
    {
        assertEquals(testingHomework.factorial(3),6);
    }

    @Test
    void factorialEvenTest1()
    {
        assertEquals(testingHomework.factorial(4),24);
    }

    @Test
    void factorialOddTest3()
    {
        assertEquals(testingHomework.factorial(5),120);
    }

    @Test
    void factorialEvenTest2()
    {
        assertEquals(testingHomework.factorial(6),720);
    }

    @Test
    void factorialOddTest()
    {
        assertEquals(testingHomework.factorial(7),5040);
    }

    @Test
    void factorialEvenTest3()
    {
        assertEquals(testingHomework.factorial(8),40320);
    }

    @Test
    void factorialOddTest1()
    {
        assertEquals(testingHomework.factorial(9),362880);
    }

    @Test
    void factorialEvenTest4()
    {
        assertEquals(testingHomework.factorial(10),3628800);
    }

    @Test
    void factorialOddTest2()
    {
        assertEquals(testingHomework.factorial(11),39916800);
    }

    @Test
    void factorialEvenTest5()
    {
        assertEquals(testingHomework.factorial(12),479001600);
    }

    //negative

    @Test
    void factorialEvenTest6()
    {
        assertThrows( RuntimeException.class, ()->testingHomework.factorial(14));

    }

    @Test
    void factorialOddTest5()
    {
        assertThrows( RuntimeException.class, ()->testingHomework.factorial(15));

    }

    @Test
    void factorialOddTest6()
    {
        assertThrows( RuntimeException.class, ()->testingHomework.factorial(101));
    }

    @Test
    void factorialEvenTest7()
    {
        assertThrows( RuntimeException.class, ()->testingHomework.factorial(1990));

    }

    @Test
    void factorialEvenTest8()
    {
        assertThrows( RuntimeException.class, ()->testingHomework.factorial(20874));
    }

    @Test
    void factorialOddTest7()
    {
        assertThrows( RuntimeException.class, ()->testingHomework.factorial(358035));
    }

    @Test
    void factorialEvenTest9()
    {
        assertThrows( RuntimeException.class, ()->testingHomework.factorial(4136378));

    }

    @Test
    void factorialEvenTest10()
    {
        assertThrows(RuntimeException.class, ()->testingHomework.factorial(11132906));

    }

    @Test
    void factorialLargeNumberTest()
    {
        assertThrows(RuntimeException.class, ()->testingHomework.factorial(894567321));
    }

    //-ve numbers
    @Test
    void factorialNegativeTest()
    {
        assertThrows( RuntimeException.class, ()->testingHomework.factorial(-2));
    }

    @Test
    void factorialNegativeTest1()
    {
        assertThrows( RuntimeException.class, ()->testingHomework.factorial(-10));
    }

    @Test
    void factorialNegativeTest2()
    {
        assertThrows( RuntimeException.class, ()->testingHomework.factorial(-331));
    }

    @Test
    void factorialNegativeTest5()
    {
        assertThrows( RuntimeException.class, ()->testingHomework.factorial(-65897));
    }


    @Test
    void factorialNegativeTest6()
    {
        assertThrows( RuntimeException.class, ()->testingHomework.factorial(-110000));
    }


    @Test
    void factorialNegativeTest7()
    {
        assertThrows( RuntimeException.class, ()->testingHomework.factorial(-2196755));
    }

    @Test
    void factorialNegativeTest8()
    {
        assertThrows( RuntimeException.class, ()->testingHomework.factorial(-5403));
    }

}
