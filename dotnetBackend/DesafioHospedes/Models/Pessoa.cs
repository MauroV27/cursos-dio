namespace DesafioHospedes.Models;

public class Pessoa
{
    public Pessoa() { 
        Nome = "";
        Sobrenome = "";
    }

    public Pessoa(string nome)
    {
        Nome = nome;
        Sobrenome = "";
    }

    public Pessoa(string nome, string sobrenome)
    {
        Nome = nome;
        Sobrenome = sobrenome;
    }

    public string Nome { get; set; }
    public string Sobrenome { get; set; }
    public string NomeCompleto => $"{Nome} {Sobrenome}".ToUpper();
}