import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

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
        Uri1612 solver = new Uri1612();
        solver.solve(1, in, out);
        out.close();
    }

    static class Uri1612 {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int t = in.nextInt();

            for (int i = 0; i < t; i++) {
                int n = in.nextInt();

                int ans = (int) Math.ceil(n / 2.0);

                out.println(ans);
            }
        }

    }
}
