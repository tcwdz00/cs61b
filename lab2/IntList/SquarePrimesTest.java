package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimes2() {
        IntList lst = IntList.of(1, 2, 3, 6, 8, 9);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("1 -> 4 -> 9 -> 6 -> 8 -> 9", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimes3() {
        IntList lst = IntList.of(8);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("8", lst.toString());
        assertFalse(changed);
    }

    @Test
    public void testSquarePrimes5() {
        IntList lst = IntList.of(3);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("9", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimes4() {
        IntList lst = IntList.of(1, 4, 10, 6, 8, 9);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("1 -> 4 -> 10 -> 6 -> 8 -> 9", lst.toString());
        assertFalse(changed);
    }
}
