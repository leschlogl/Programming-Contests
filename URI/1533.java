import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
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
        Uri1533 solver = new Uri1533();
        solver.solve(1, in, out);
        out.close();
    }

    static class Uri1533 {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();

            while (n != 0) {

                int pos[] = new int[n];
                HashMap<Integer, Integer> mapPos = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    int num = in.nextInt();
                    pos[i] = num;
                    mapPos.put(num, i + 1);
                }

                Arrays.sort(pos);

                out.println(mapPos.get(pos[n - 2]));

                n = in.nextInt();
            }

        }

    }
}

