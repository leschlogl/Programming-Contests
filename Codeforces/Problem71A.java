import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem71A solver = new Problem71A();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem71A {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int qty = in.nextInt();

            for (int i = 0; i < qty; i++) {
                String word = in.next();

                if (word.length() <= 10) {
                    out.println(word);
                } else {
                    String outStr = "" + word.charAt(0);
                    outStr += (word.length() - 2) + "";
                    outStr += word.charAt(word.length() - 1);
                    out.println(outStr);
                }
            }
        }

    }
}
