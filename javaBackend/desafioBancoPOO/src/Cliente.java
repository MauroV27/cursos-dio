public class Cliente {

    static private int incrementeId = 1;
	private int id;
    private String nome;

    Cliente(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    Cliente(String nome){
        this.id = incrementeId;
        this.nome = nome;

        incrementeId += 1;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}