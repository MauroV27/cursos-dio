package dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo{

    private LocalDate data;

    @Override
    public double calcularXp() {
        return this.XP_PADRAO + 20d;
    }

    public Mentoria() {
    }

    public Mentoria(String titulo, String descricao, LocalDate data ) {
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        
        this.data = data;
    }


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "\n\t - Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + data +
                '}';
    }
}