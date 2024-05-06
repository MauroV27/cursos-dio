namespace Models.Calculadora;

public class Calculadora
{

    private List<string> _historico = new List<string>();
    private int _tamanhoMaximoHistorico;

    public Calculadora( int tamanhoHistorico = 3){
        _tamanhoMaximoHistorico = tamanhoHistorico;
    }

    public int Somar( int a, int b){
        int res = a + b;
        AdicionaElementoNoHistorico(res);
        return res;
    }

    public int Subtrair( int a, int b){
        int res = a - b;
        AdicionaElementoNoHistorico(res);
        return res;
    }

    public int Multiplicar( int a, int b){
        int res = a * b;
        AdicionaElementoNoHistorico(res);
        return res;
    }

    public int Dividir( int a, int b){

        if ( b == 0) {
            throw new DivideByZeroException();
        }

        int res = a / b;
        AdicionaElementoNoHistorico(res);
        return res;
    }

    private void AdicionaElementoNoHistorico(int elem){

        string valor = $"Res : {elem}";

        if ( _historico.Count < _tamanhoMaximoHistorico ) {
            _historico.Add( valor );
        } else {
            _historico.RemoveAt(0);
            _historico.Add( valor );
        }

    }

    public List<string> Historico(){
        return _historico;
    }

}