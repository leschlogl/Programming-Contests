import java.io.IOException;
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
		int r = leitor.nextInt();
		leitor.close();
		long resposta = (long) Math.pow(3, r);
		System.out.format("%01d\n", resposta);


    }

}
