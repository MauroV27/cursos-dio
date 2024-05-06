using Models.Calculadora;

namespace DesafioTDD.Tests;
public class CalculadoraTest
{

    private readonly Calculadora _calc = new Calculadora();

    [Theory]
    [InlineData(1, 2, 3)]
    [InlineData(1, 1, 2)]
    public void TestandoSoma( int numA, int numB, int expected){
        // Act 
        var resp = _calc.Somar(numA, numB);

        // Asset
        Assert.Equal(resp, expected); 
    }

    [Theory]
    [InlineData(3, 2, 1)]
    [InlineData(9, 1, 8)]
    public void TestandoSubtracao( int numA, int numB, int expected){
        // Act 
        var resp = _calc.Subtrair(numA, numB);

        // Asset
        Assert.Equal(resp, expected); 
    }

    [Theory]
    [InlineData(3, 2, 6)]
    [InlineData(4, 2, 8)]
    [InlineData(1, 0, 0)]
    public void TestandoMultiplicacao( int numA, int numB, int expected){
        // Act 
        var resp = _calc.Multiplicar(numA, numB);

        // Asset
        Assert.Equal(resp, expected); 
    }

    [Theory]
    [InlineData(6, 2, 3)]
    [InlineData(4, 2, 2)]
    public void TestandoDivisao( int numA, int numB, int expected){
        // Act 
        var resp = _calc.Dividir(numA, numB);

        // Asset
        Assert.Equal(resp, expected); 
    }

    [Fact]
    public void TestandoDivisaoPorZero(){
        // Arrange :
        int numA = 10;
        
        // Act/Assert :
        Assert.Throws<DivideByZeroException>(
            () => _calc.Dividir(numA, 0)    
        );
    }

    [Fact]
    public void TestandoHistoricoArmazena3UltimasOperacoes(){

        Calculadora calc = new Calculadora();

        calc.Somar(3, 5);
        calc.Somar(3, 5);
        calc.Somar(3, 5);
        calc.Somar(3, 5);

        var lista = calc.Historico();

        // Assert :
        Assert.NotEmpty(lista);
        Assert.Equal(3, lista.Count);

    }

    [Fact]
    public void TestandoOrdemDoHistorico(){

        int sizeHistorico = 4;
        Calculadora calc = new Calculadora(sizeHistorico);
        string[] resps = new string[4]; //Res : 

        resps[0] = $"Res : {calc.Somar(3, 5)}";
        resps[1] = $"Res : {calc.Somar(1, 2)}";
        resps[2] = $"Res : {calc.Somar(3, 4)}"; 
        resps[3] = $"Res : {calc.Somar(6, 5)}";

        var lista = calc.Historico();

        // Assert :
        Assert.NotEmpty(lista);
        Assert.Equal(sizeHistorico, lista.Count);
        Assert.Equal(resps, lista);

    }

}