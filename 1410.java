import java.io.IOException;
 import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * IMPORTANT:
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Main {

    public static void main(String[] args) throws IOException {


		Scanner leitor = new Scanner(System.in);

		int numAtacantes = leitor.nextInt();
		int numDefensores = leitor.nextInt();
		while (numAtacantes != 0 && numDefensores != 0) {

			ArrayList<Integer> distAtacantes = new ArrayList<Integer>();
			for (int i = 0; i < numAtacantes; i++) {
				int num = leitor.nextInt();
				distAtacantes.add(num);
			}
			ArrayList<Integer> distDefensores = new ArrayList<Integer>();
			for (int i = 0; i < numDefensores; i++) {
				int num = leitor.nextInt();
				distDefensores.add(num);
			}

			int atqMenorDist = Collections.min(distAtacantes);
			//Remove o goleiro
			distDefensores.remove(Collections.min(distDefensores));
			//pega o zagueiro
			int defMenorDist = Collections.min(distDefensores);

			// ta na frente do zagueiro
			if (atqMenorDist >= defMenorDist) {
				System.out.println("N");
			} else {
				System.out.println("Y");
			}

			numAtacantes = leitor.nextInt();
			numDefensores = leitor.nextInt();

		}

		leitor.close();

    }

}
