import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(" >> CONTA BANCÁRIA << \n");
		
		System.out.println("Digite o número da Conta :");
        int numero = sc.nextInt();

		System.out.println("Digite o número da Agência : ");
		String agencia = sc.next();

		System.out.println("Digite seu nome : ");
		String nomeCliente = sc.next();
		sc.nextLine();

		System.out.println("Digite seu saldo atual: ");
		Double saldo = sc.nextDouble();

		System.out.println("\n >>> Conta criada com sucesso <<<\n");

		System.out.printf(
			"Olá %s, \nobrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque", 
			nomeCliente, agencia, numero, saldo
			);

		sc.close();


    }

}