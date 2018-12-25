package homework.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Sushmita Chaudhari
 */
class TestingHomeworkImplSimpleFunctionXplusYTest {

    private TestingHomework testingHomework;

    @BeforeEach
    void setup()
    {
        testingHomework = new TestingHomeworkImpl();
    }

    @Test
    void simpleFunctionXplusYboundaryTest() {
        assertThrows(RuntimeException.class, () -> testingHomework.simpleFunctionXplusY(Integer.MIN_VALUE,
                Integer.MIN_VALUE));
    }

    @Test
    void simpleFunctionXplusYboundaryTest1() {
        assertThrows(RuntimeException.class, () -> testingHomework.simpleFunctionXplusY(Integer.MIN_VALUE + 1,
                Integer.MIN_VALUE + 1));
    }

    @Test
    void simpleFunctionXplusYboundaryTest2() {
        assertThrows(RuntimeException.class, () -> testingHomework.simpleFunctionXplusY(Integer.MAX_VALUE,
                Integer.MAX_VALUE));
    }

    @Test
    void simpleFunctionXplusYboundaryTest3() {
        assertThrows(RuntimeException.class, () -> testingHomework.simpleFunctionXplusY(Integer.MAX_VALUE - 1,
                Integer.MAX_VALUE - 1));
    }

    // boundary
    @Test
    void simpleFunctionXplusYboundaryTest11() {
        assertEquals(testingHomework.simpleFunctionXplusY(Integer.MAX_VALUE / 2, Integer.MAX_VALUE/2),
                ((Integer.MAX_VALUE / 2 )+ (Integer.MAX_VALUE/2)));
    }

    @Test
    void simpleFunctionXplusYboundaryTest12() {
        assertThrows(RuntimeException.class, ()->testingHomework.simpleFunctionXplusY(Integer.MAX_VALUE,
                (Integer.MAX_VALUE/2) + 1));
    }

    @Test
    void simpleFunctionXplusYboundaryTest13() {
        assertThrows(RuntimeException.class, ()->testingHomework.simpleFunctionXplusY(Integer.MAX_VALUE, 1));
    }


    @Test
    void simpleFunctionXplusYboundaryTest4() {
        assertEquals(testingHomework.simpleFunctionXplusY(Integer.MAX_VALUE, Integer.MIN_VALUE), -1);
    }

    @Test
    void simpleFunctionXplusYboundaryTest5() {
        assertEquals(testingHomework.simpleFunctionXplusY(Integer.MIN_VALUE, Integer.MAX_VALUE), -1);
    }

    @Test
    void simpleFunctionXplusYboundaryTest6() {
        assertEquals(testingHomework.simpleFunctionXplusY(1,1), 2);
    }

    @Test
    void simpleFunctionXplusYboundaryTest7() {
        assertEquals(testingHomework.simpleFunctionXplusY(-1,1), 0);
    }

    @Test
    void simpleFunctionXplusYboundaryTest8() {
        assertEquals(testingHomework.simpleFunctionXplusY(0,0), 0);
    }

    @Test
    void simpleFunctionXplusYboundaryTest9() {
        assertEquals(testingHomework.simpleFunctionXplusY(1,-1), 0);
    }


    //positive
    @Test
    void simpleFunctionXplusYEvenTest() {
        assertEquals(testingHomework.simpleFunctionXplusY(908, 200), 908 + 200);
    }

    @Test
    void simpleFunctionXplusYOddEvenTest() {
        assertEquals(testingHomework.simpleFunctionXplusY(1289, 4356), 1289 + 4356);
    }

    @Test
    void simpleFunctionXplusYOddTest() {
        assertEquals(testingHomework.simpleFunctionXplusY(890326783, 902233311), 890326783 + 902233311);
    }

    @Test
    void simpleFunctionXplusYOddEvenTest1() {
        assertEquals(testingHomework.simpleFunctionXplusY(34987, 10002), 34987 + 10002);
    }

    @Test
    void simpleFunctionXplusYOddEvenTest2() {
        assertEquals(testingHomework.simpleFunctionXplusY(123098, 346743), 123098 + 346743);
    }

    @Test
    void simpleFunctionXplusYOddEvenTest3() {
        assertEquals(testingHomework.simpleFunctionXplusY(5437893, 1000456), 5437893 + 1000456);
    }

    @Test
    void simpleFunctionXplusYOddEvenTest4() {
        assertEquals(testingHomework.simpleFunctionXplusY(12903456, 2389345), 12903456 + 2389345);
    }

    @Test
    void simpleFunctionXplusYOddTest1() {
        assertEquals(testingHomework.simpleFunctionXplusY(129034561, 129034561), 129034561 +129034561);
    }

    //positive and negative
    @Test
    void simpleFunctionXplusYOddEvenTest5() {

        assertEquals(testingHomework.simpleFunctionXplusY(345678222, -345678921), 345678222 + (-345678921));
    }

    @Test
    void simpleFunctionXplusYNegativeTest() {
        assertEquals(testingHomework.simpleFunctionXplusY(-348962, 789321), (-348962) + 789321);
    }

    @Test
    void simpleFunctionXplusYNegativeTest1() {
        assertEquals(testingHomework.simpleFunctionXplusY(-45789, 900021), (-45789) + 900021);
    }


    @Test
    void simpleFunctionXplusYNegativeTest2() {
        assertEquals(testingHomework.simpleFunctionXplusY(-345, 678), -345 + 678);
    }


    @Test
    void simpleFunctionXplusYNegativeTest3() {
        assertEquals(testingHomework.simpleFunctionXplusY(-23, 90), -23 + 90);
    }

    //-ve and -ve
    @Test
    void simpleFunctionXplusYNegativeTest5() {
        assertEquals(testingHomework.simpleFunctionXplusY(-4, -6), -4 + -6);
    }

    @Test
    void simpleFunctionXplusYNegativeTest6() {
        assertEquals(testingHomework.simpleFunctionXplusY(-23, -99), -23 + -99);
    }

    @Test
    void simpleFunctionXplusYNegativeTest7() {
        assertEquals(testingHomework.simpleFunctionXplusY(-999, -111), -999 + -111);
    }

    @Test
    void simpleFunctionXplusYNegativeTest8() {
        assertEquals(testingHomework.simpleFunctionXplusY(-1234, -9876), ((-1234) + (-9876)));

    }

    @Test
    void simpleFunctionXplusYNegativeTest9() {
        assertEquals(testingHomework.simpleFunctionXplusY(-45673, -78367), ((-45673) + (-78367)));
    }

    @Test
    void simpleFunctionXplusYNegativeTest10() {
        assertEquals(testingHomework.simpleFunctionXplusY(-896543, -346888), ((-896543) + (-346888)));
    }

    @Test
    void simpleFunctionXplusYNegativeTest11() {
        assertEquals(testingHomework.simpleFunctionXplusY(-26789432, -6743218), ((-26789432) + (-6743218)));
    }
    @Test
    void simpleFunctionXplusYNegativeTest12() {
        assertEquals(testingHomework.simpleFunctionXplusY(-890321566, -10012311), ((-890321566) + (-10012311)));
    }



}
