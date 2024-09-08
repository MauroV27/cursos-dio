package dominio;

public class Curso extends Conteudo{

    private int cargaHoraria;

    @Override
    public double calcularXp() {
        return this.XP_PADRAO * cargaHoraria;
    }

    public Curso() {
    }

    public Curso(String titulo, String descricao, int cargaHoraria ) {
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "\n\t - Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}