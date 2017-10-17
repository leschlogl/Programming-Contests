import java.io.*;
import java.util.*;

public class Main implements Runnable {

	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");

	boolean judge = false;

	public static void main(String[] args) {
		new Thread(null, new Main(), "", 256 * (1L << 20)).start();
	}

	public void run() {
		try {
			long t1 = System.currentTimeMillis();

			if (judge) {
				in = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(System.out);
			} else {
				in = new BufferedReader(new FileReader("input.txt"));
				out = new PrintWriter("output.txt");
			}

			Locale.setDefault(Locale.US);
			solve();
			in.close();
			out.close();
			if (!judge) {
				long t2 = System.currentTimeMillis();
				System.err.println("Time = " + (t2 - t1));
			}
		} catch (Throwable t) {
			t.printStackTrace(System.err);
			System.exit(-1);
		}
	}

	String readString() throws IOException {
		while (!tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	int readInt() throws IOException {
		return Integer.parseInt(readString());
	}

	long readLong() throws IOException {
		return Long.parseLong(readString());
	}

	double readDouble() throws IOException {
		return Double.parseDouble(readString());
	}

	float readFloat() throws IOException {
		return Float.parseFloat(readString());
	}

	// solution

	void solve() throws IOException {
		int qtdeRepeticoes = readInt();

		System.out.print("Feliz nat");
		for (int i = 0; i < qtdeRepeticoes; i++) {
			out.print("a");
		}
		out.println("l!");
	}

}
