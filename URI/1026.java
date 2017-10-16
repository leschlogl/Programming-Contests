import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {

		Scanner leitor = new Scanner(System.in);

		long a, b;

		String line = leitor.nextLine();

		while (line != null && !line.isEmpty()) {

			a = Long.parseLong(line.split(" ")[0]);
			b = Long.parseLong(line.split(" ")[1]);

			System.out.println(a^b);

			if (leitor.hasNextLine())
				line = leitor.nextLine();
			else
				break;

		}

		leitor.close();

	}

}
