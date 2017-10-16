import java.util.*;
import java.lang.*;

public class Main {

	public static void main(String[] args) throws java.lang.Exception {
		Scanner leitor = new Scanner(System.in);

		while (leitor.hasNextInt()) {

			int qtdeCompetidores = leitor.nextInt();

			int[] ordemChegada = new int[qtdeCompetidores];
			int[] ordemLargada = new int[qtdeCompetidores];

			for (int i = 0; i < ordemLargada.length; i++) {
				ordemLargada[i] = leitor.nextInt();
			}

			for (int i = 0; i < ordemChegada.length; i++) {
				ordemChegada[i] = leitor.nextInt();
			}

			int qtde = sort(ordemChegada, ordemLargada);

			System.out.println(qtde);
		}
	}

	public static int sort(int[] ordemChegada, int[] ordemLargada) {
		int qtdeMudancas = 0;

		int[] arrayPosicoes = new int[ordemChegada.length];

		for (int i = 0; i < arrayPosicoes.length; i++) {
			for (int j = 0; j < arrayPosicoes.length; j++) {
				if (ordemChegada[i] == ordemLargada[j]) {
					arrayPosicoes[i] = j + 1;
					break;
				}
			}
		}

		for (int k = 0; k < arrayPosicoes.length - 1; k++) {
			for (int i = 1; i < arrayPosicoes.length - k; i++) {
				if (arrayPosicoes[i] < arrayPosicoes[i - 1]) {
					int temporaria = arrayPosicoes[i];
					arrayPosicoes[i] = arrayPosicoes[i - 1];
					arrayPosicoes[i - 1] = temporaria;
					qtdeMudancas++;
				}
			}

		}

		return qtdeMudancas;
	}
}
