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
        Uri1924 solver = new Uri1924();
        solver.solve(1, in, out);
        out.close();
    }

    static class Uri1924 {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();

            for (int i = 0; i < n; i++) {
                in.next();
            }
            out.println("Ciencia da Computacao");
        }

    }
}
