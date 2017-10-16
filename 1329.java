import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Locale.setDefault(Locale.US);

		Scanner leitor = new Scanner(System.in);

		int n = leitor.nextInt();

		do {
			int mary = 0;
			int john = 0;

			for (int i = 0; i < n; i++) {
				if(leitor.nextInt() == 0) {
					mary++;
				} else {
					john++;
				}
			}

			n = leitor.nextInt();

			System.out.println("Mary won " + mary + " times and John won " + john + " times" );

		} while (n != 0);




	}

}
