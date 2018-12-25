package homework.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Sushmita Chaudhari
 */
class TestingHomeworkImplDespacerTest {

    private TestingHomework testingHomework = new TestingHomeworkImpl();

    @Test
    void testEmptyStringDespacer()
    {
        assertEquals(testingHomework.despacer(""),"");
    }

    @Test
    void testSingleSpaceDespacer()
    {
        assertEquals(testingHomework.despacer(" ")," ");
    }

    @Test
    void testDoubleSpaceDespacer()
    {
        assertEquals(testingHomework.despacer("   ")," ");
    }

    @Test
    void testTripleSpaceDespacer()
    {
        assertEquals(testingHomework.despacer("   ")," ");
    }

    @Test
    void testSingleSpaceCharDespacer()
    {
        assertEquals(testingHomework.despacer(" a")," a");
    }

    @Test
    void testDoubleSpaceCharDespacer()
    {
        assertEquals(testingHomework.despacer("  a")," a");
    }

    @Test
    void testWordsWithSingleSpaceDespacer()
    {
        assertEquals(testingHomework.despacer("Hello World!"),
                "Hello World!");
    }

    @Test
    void testWordsWithSingleSpaceOutsideDespacer()
    {
        assertEquals(testingHomework.despacer(" Hello World! ")," Hello World! ");
    }

    @Test
    void testWordsWithDoubleSpaceOutsideDespacer()
    {
        assertEquals(testingHomework.despacer("  Hello   World!  ")," Hello World! ");
    }

    @Test
    void testALongContiguosSpaceDespacer()
    {
        assertEquals(testingHomework.despacer("                                       ")," ");
    }

    @Test
    void testALongContiguosSpaceDespacer1()
    {
        assertEquals(testingHomework.despacer("                                           " +
                "                                                                                       " +
                "                                                                                       ")," ");
    }

    @Test
    void testASenteceWithLongSpaceDespacer()
    {
        assertEquals(testingHomework.despacer("This  is a      test. "),"This is a test.");
    }

    @Test
    void testASenteceWithLongSpaceDespacer1()
    {
        assertEquals(testingHomework.despacer("  This      is another  test.  "),
                " This is another test. ");
    }

    @Test
    void testSpecialCharacterWithSingleSpace4()
    {
        assertEquals(testingHomework.despacer("abc   "+"&*("+"def"),"abc "+"&*("+"def");
    }


    @Test
    void testSpecialCharacterWithSingleSpace5()
    {
        assertEquals(testingHomework.despacer("     @   #$   %   ^      &   *   (    "),
                " @ #$ % ^ & * ( ");
    }

    @Test
    void testWithInvalidInputShouldThrowException() {

        assertThrows(RuntimeException.class, ()->testingHomework.despacer(null));

    }

}
