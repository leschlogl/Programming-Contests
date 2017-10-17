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
		float n1 = readFloat();
		float n2 = readFloat();
		float n3 = readFloat();
		float n4 = readFloat();

		float media = ((n1 * 2) + (n2 * 3) + (n3 * 4) + (n4 * 1)) / 10;

		out.printf("Media: %.1f\n", media);
		if (media >= 7.0) {
			out.println("Aluno aprovado.");
		} else if (media < 5) {
			out.println("Aluno reprovado.");
		} else {
			out.println("Aluno em exame.");
			float nExame = readFloat();
			out.printf("Nota do exame: %.1f\n", nExame);

			float media2 = (nExame + media) / 2;

			if (media2 >= 5.0) {
				out.println("Aluno aprovado.");
			} else {
				out.println("Aluno reprovado.");
			}

			out.printf("Media final: %.1f\n", media2);

		}
	}

}
