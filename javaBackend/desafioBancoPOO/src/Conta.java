
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    private final String tipoConta;

    public Conta(Cliente cliente, String tipoConta) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.tipoConta = tipoConta;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoConta(){
        return this.tipoConta;
    }

    public String getClienteNome() {
        return this.cliente.getNome();
    }

    protected void imprimirInfosComuns() {
//        System.out.printf("Titular: %s%n", this.cliente.getNome());
//        System.out.printf("Agencia: %d%n", this.agencia);
//        System.out.printf("Numero: %d%n", this.numero);
//        System.out.printf("Tipo conta: %s%n", this.tipoConta);
//        System.out.printf("Saldo: %.2f%n", this.saldo);

        System.out.println("- Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                ", tipoConta='" + tipoConta + '\'' +
                '}');

    }

}