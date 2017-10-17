import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Locale.setDefault(Locale.US);

		Scanner leitor = new Scanner(System.in);

		int soma = 0;
		int nrPessoas = 0;

		while (leitor.hasNext()) {
			leitor.nextLine();
			soma += Integer.parseInt(leitor.nextLine());
			nrPessoas++;
		}

		float media = soma/(float)nrPessoas;
		System.out.format("%.1f\n", media);

	}
}
