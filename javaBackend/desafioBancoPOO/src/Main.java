
public class Main {

    public static void main(String[] args) {

        Banco banco = new Banco();

        Cliente mauro = new Cliente("Mauro");
        Cliente victor = new Cliente("Victor");
        Cliente ana = new Cliente("Ana");

        ContaCorrente mauroContaCorrente = banco.criarContaCorrente(mauro);
        ContaPoupanca mauroContaPoupanca = banco.criarContaPoupanca(mauro);
        ContaCorrente victorContaCorrente = banco.criarContaCorrente(victor);
        ContaPoupanca anaContaPoupanca = banco.criarContaPoupanca(ana);

        System.out.println("Listando todas as contas :");
        banco.listarContas();

        System.out.println("\n- Listando todas as contas correntes:");
        for ( Conta c : banco.getContasCorrente() ){
            System.out.println("\t - " + c.getClienteNome());
        }

        System.out.println("\n- Listando todas as contas poupanca:");
        for ( Conta c : banco.getCpntasPoupanca() ){
            System.out.println("\t - " + c.getClienteNome());
        }

        System.out.println("\n//mauroContaCorrente começa com 1000 e victorContaCorrente com 800");
        mauroContaCorrente.depositar(1000);
        victorContaCorrente.depositar(800);

        System.out.println("\n//mauroContaCorrente transfere 100 para mauroContaPoupanca");
        mauroContaCorrente.transferir(100, mauroContaPoupanca);

        System.out.println("\n//mauroContaCorrente transfere 50 para victorContaCorrente");
        mauroContaCorrente.transferir(50, victorContaCorrente);

        System.out.println("\n//victorContaCorrente saca 300");
        victorContaCorrente.sacar(300);

        System.out.println("\n//anaContaPoupanca deposita 200");
        anaContaPoupanca.depositar(200);

        mauroContaCorrente.imprimirExtrato();
        mauroContaPoupanca.imprimirExtrato();
        victorContaCorrente.imprimirExtrato();
        anaContaPoupanca.imprimirExtrato();
    }

}
