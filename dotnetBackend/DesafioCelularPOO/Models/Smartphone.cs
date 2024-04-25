namespace DesafioCelularPOO.Models
{
    public abstract class Smartphone
    {
        public string Numero { get; set; }
        
        private string Modelo;
        private string IMEI;
        private int Memoria;
        protected string NomeMarca = "Undefined";

        public Smartphone(string numero, string modelo, string imei, int memoria)
        {
            Numero = numero;
            
            Modelo = modelo;
            IMEI = imei;
            Memoria = memoria;
        }

        public void Ligar()
        {
            Console.WriteLine("Ligando...");
        }

        public void ReceberLigacao()
        {
            Console.WriteLine("Recebendo ligação...");
        }

        public void ApresentaPropriedadesSmartphone(){
            Console.WriteLine($"Configurações do {NomeMarca}/{Modelo}");
            Console.WriteLine($" - Número : {Numero} \n - IMEI: {IMEI} \n - Memória : {Memoria} GB");
        }

        public abstract void InstalarAplicativo(string nomeApp);
    }
}