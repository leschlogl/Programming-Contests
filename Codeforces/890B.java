import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Lucas Eduardo Schlogl
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, Scanner in, PrintWriter out) {

            int n = in.nextInt();

            HashMap<Integer, Integer> lastVisit = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                lastVisit.put(num, i);
            }

            int idx = Integer.MAX_VALUE;
            int nidx = Integer.MAX_VALUE;
            Iterator it = lastVisit.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();

                if ((Integer) pair.getValue() < nidx) {
                    idx = (int) pair.getKey();
                    nidx = (int) pair.getValue();
                }
                it.remove();
            }
            out.println(idx);
        }

    }
}
