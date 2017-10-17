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

		int n = readInt();
		int d = readInt();

		while (n != 0 && d != 0) {

			boolean alunos[][] = new boolean[n][d];

			// read
			for (int i = 0; i < d; i++) {
				for (int j = 0; j < n; j++) {
					// se int == 1 entao é verdadeiro e ele foi a aquele jantar
					alunos[j][i] = readInt() == 1;
				}
			}

			// se algum aluno participou de todos os jantares imprime YES
			if (hasSomeStudentAllDays(alunos, n, d)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

			n = readInt();
			d = readInt();
		}

	}

	boolean hasSomeStudentAllDays(boolean alunos[][], int n, int d) {

		for (int i = 0; i < alunos.length; i++) {
			boolean allTrue = true;
			for (int j = 0; j < alunos[i].length; j++) {
				if(alunos[i][j] == false) {
					allTrue = false;
					break;
				}
			}
			if(allTrue)
				return true;
		}
		return false;
	}

}
