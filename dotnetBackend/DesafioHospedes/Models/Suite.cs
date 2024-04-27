namespace DesafioHospedes.Models
{
    public class Suite
    {
        public Suite() { 
            TipoSuite = "";
            Capacidade = 0;
            ValorDiaria = 0M;
        }

        public Suite(string tipoSuite, int capacidade, decimal valorDiaria)
        {
            TipoSuite = tipoSuite;
            Capacidade = capacidade;
            ValorDiaria = valorDiaria;
        }

        public string TipoSuite { get; set; }
        public int Capacidade { get; set; }
        public decimal ValorDiaria { get; set; }


        public string SuitePropriedades(){
            return $" - Tipo Suíte : {TipoSuite}\n - Capacidade : {Capacidade} hóspedes\n - Valor Diária : {ValorDiaria}";
        }


    }
}