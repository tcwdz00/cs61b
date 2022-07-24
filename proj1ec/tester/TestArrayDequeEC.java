package tester;
import static org.junit.Assert.*;
import org.junit.Test;
import student.StudentArrayDeque;
import edu.princeton.cs.algs4.StdRandom;

public class TestArrayDequeEC {
    @Test
    public void randomizedTest() {
        StudentArrayDeque<Integer> L = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> R = new ArrayDequeSolution<>();
        String msg = "";
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                R.addLast(randVal);
                msg += "addLast(" + randVal + ")\n";
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                int randVal = StdRandom.uniform(0, 100);
                L.addFirst(randVal);
                R.addFirst(randVal);
                msg += "addFirst(" + randVal + ")\n";
                //System.out.println("addFirst(" + randVal + ")");
            } else if (operationNumber == 2) {
                if (L.size() == 0) continue;
                int lFirst = L.removeFirst();
                int rfirst = R.removeFirst();
                msg += "removeFirst()\n";
                assertEquals(msg, lFirst, rfirst);


            }
            // remove last ele
            else {
                if (L.size() == 0) continue;
                int L_last = L.removeLast();
                int R_last = R.removeLast();
                msg += "removeLast()\n";
                assertEquals(msg, L_last, R_last);

            }

        }
    }
}
