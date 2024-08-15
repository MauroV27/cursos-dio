import java.util.ArrayList;

public class Banco {

	private String nome;
	private ArrayList<Conta> contas = new ArrayList<Conta>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}

	public ArrayList<Conta> getContasCorrente(){
		ArrayList<Conta> contasCorrentes = new ArrayList<Conta>();

		for ( Conta c : this.contas ){
			if (c.getTipoConta().equals("corrente")){
				contasCorrentes.add(c);
			}
		}

		return contasCorrentes;
	}


	public ArrayList<Conta> getCpntasPoupanca(){
		ArrayList<Conta> contasPoupanca = new ArrayList<Conta>();

		for ( Conta c : this.contas ){
			if (c.getTipoConta().equals("poupanca")){
				contasPoupanca.add(c);
			}
		}

		return contasPoupanca;
	}

	public ContaCorrente criarContaCorrente(Cliente cliente){

		ContaCorrente novaConta = new ContaCorrente(cliente);
		this.contas.add(novaConta);

		return novaConta;
	}

	public ContaPoupanca criarContaPoupanca(Cliente cliente){

		ContaPoupanca novaConta = new ContaPoupanca(cliente);
		this.contas.add(novaConta);

		return novaConta;
	}

	public void listarContas(){
		for (Conta c : this.contas){
			System.out.println("-> Cliente : " + c.getClienteNome() + " | Tipo conta : " + c.getTipoConta() );
		}
	}
}
