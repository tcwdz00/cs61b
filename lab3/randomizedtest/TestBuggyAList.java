package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> lst = new AListNoResizing<>();
        BuggyAList<Integer> buggyLst = new BuggyAList<>();
        lst.addLast(4);
        buggyLst.addLast(4);
        lst.addLast(5);
        buggyLst.addLast(5);
        lst.addLast(6);
        buggyLst.addLast(6);
        assertEquals(lst.size(), buggyLst.size());
        assertEquals(lst.removeLast(), buggyLst.removeLast());
        assertEquals(lst.removeLast(), buggyLst.removeLast());
        assertEquals(lst.removeLast(), buggyLst.removeLast());
  }
    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> R = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 4);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              L.addLast(randVal);
              R.addLast(randVal);
              //System.out.println("addLast(" + randVal + ")");
          } else if (operationNumber == 1) {
              // size
              int size = L.size();
              int R_size = R.size();
              assertEquals(size, R_size);
              //System.out.println("size: " + size);

          } else if (operationNumber == 2) {
              if (L.size() == 0) continue;
              int last = L.getLast();
              int R_last = R.getLast();
              assertEquals(last, R_last);


          }
          // remove last ele
          else {
              if (L.size() == 0) continue;
              int last = L.removeLast();
              int R_last = R.removeLast();
              assertEquals(last, R_last);

          }

        }
        }

}
