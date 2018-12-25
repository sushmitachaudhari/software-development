package homework.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Sushmita Chaudhari
 */
class TestingHomeworkImplSumUpTest {

    private TestingHomework testingHomework;

    @BeforeEach
    void setup()
    {
        testingHomework = new TestingHomeworkImpl();
    }

    @Test
    void boundarySumUpTest()
    {
        assertThrows(RuntimeException.class, ()-> testingHomework.sumUp(Integer.MAX_VALUE));
    }

    @Test
    void boundarySumUpTest1()
    {
        assertThrows(RuntimeException.class, ()-> testingHomework.sumUp(Integer.MAX_VALUE - 1));
    }

    @Test
    void boundarySumUpTest2()
    {
        assertThrows(RuntimeException.class, ()->testingHomework.sumUp(Integer.MIN_VALUE));
    }

    @Test
    void boundarySumUpTest3()
    {
        assertThrows(RuntimeException.class,()->testingHomework.sumUp(Integer.MIN_VALUE + 1));
    }

    @Test
    void SumUpTillOneTest()
    {
      assertEquals(testingHomework.sumUp(1), 1);
    }

    @Test
    void SumUpTillTwoTest()
    {
        assertEquals(testingHomework.sumUp(2), 3);
    }

    @Test
    void SumUpEvenTest()
    {
        assertEquals(testingHomework.sumUp(10),  ((10/2)*(10 + 1)));
    }

    @Test
    void SumUpOddTest()
    {
        assertEquals(testingHomework.sumUp(17),  ((17/2)*(17 + 1)));
    }

    @Test
    void SumUpEvenTest1()
    {
        assertEquals(testingHomework.sumUp(20),  ((20/2)*(20 + 1)));
    }

    @Test
    void SumUpEvenTest2()
    {
        assertEquals(testingHomework.sumUp(234),  ((234/2)*(234 + 1)));
    }

    @Test
    void SumUpEvenTest3()
    {
        assertEquals(testingHomework.sumUp(300),  ((300/2)*(300 + 1)));
    }

    @Test
    void SumUpEvenTest4()
    {
        assertEquals(testingHomework.sumUp(396),  ((396/2)*(396 + 1)));
    }

    @Test
    void SumUpEvenTest5()
    {
        assertEquals(testingHomework.sumUp(4096),  ((4096/2)*(4096 + 1)));
    }

    @Test
    void SumUpOddTest1()
    {
        assertEquals(testingHomework.sumUp(5579),  ((5579/2)*(5579 + 1)));
    }

    @Test
    void SumUpOddTest2()
    {
        assertEquals(testingHomework.sumUp(60139), ((60139/2)*(60139 + 1)));
    }



    @Test
    void SumUpOddBoundaryTest()
    {
        assertEquals(testingHomework.sumUp(65535), ((65535/2)*(65535 + 1)));
    }

    //out of boundary

    @Test
    void SumUpEvenTest6()
    {
        assertThrows(RuntimeException.class, ()-> testingHomework.sumUp(110034));

    }

    @Test
    void SumUpOddTest3()
    {
        assertThrows(RuntimeException.class, ()-> testingHomework.sumUp(1009435));
    }

    @Test
    void SumUpOddTest4()
    {
        assertThrows(RuntimeException.class, ()-> testingHomework.sumUp(76339435));

    }

    @Test
    void SumUpOddTest5()
    {
        assertThrows(RuntimeException.class, ()-> testingHomework.sumUp(432119435));
    }

    @Test
    void boundarySumUpTest4()
    {
        assertEquals(testingHomework.sumUp(0), 0);
    }

    //tests for -ve number < 0

    @Test
    void sumUpNegativeNumber0()
    {
        assertThrows(RuntimeException.class, ()->testingHomework.sumUp(-1));
    }

    @Test
    void sumUpNegativeNumber1()
    {
        assertThrows(RuntimeException.class, ()->testingHomework.sumUp(-19));
    }



    @Test
    void sumUpNegativeNumber2()
    {
        assertThrows(RuntimeException.class, ()->testingHomework.sumUp(-186));
    }



    @Test
    void sumUpNegativeNumber3()
    {
        assertThrows(RuntimeException.class, ()->testingHomework.sumUp(-9876));
    }



    @Test
    void sumUpNegativeNumber4()
    {
        assertThrows(RuntimeException.class, ()->testingHomework.sumUp(-23459));
    }


    @Test
    void sumUpNegativeNumber5()
    {
        assertThrows(RuntimeException.class, ()->testingHomework.sumUp(-129053));
    }



    @Test
    void sumUpNegativeNumber6()
    {
        assertThrows(RuntimeException.class, ()->testingHomework.sumUp(-6543219));
    }


    @Test
    void sumUpNegativeNumber7()
    {
        assertThrows(RuntimeException.class, ()->testingHomework.sumUp(-900021678));
    }






}
