package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> ops = new AList<>();
        int N = 1000;
        for (int i = 0; i < 8; i++) {
            Ns.addLast(N);
            SLList<Integer> lst = new SLList<>();
            insertNtimes(lst, N);
            Stopwatch sw = new Stopwatch();
            int numOps = 10000;
            testGetLast(lst,numOps);
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
            ops.addLast(numOps);
            N *= 2;
        }
        printTimingTable(Ns, times, ops);
    }

    public static void insertNtimes(SLList<Integer> lst, int N) {
        int j = 0;
        for (int i = 0; i < N; i++) {
            lst.addFirst(j);
            j++;
        }
    }

    public static void testGetLast(SLList<Integer> lst, int numOps) {
        for (int i = 0; i < numOps; i++) {
            lst.getLast();
        }
    }

}
