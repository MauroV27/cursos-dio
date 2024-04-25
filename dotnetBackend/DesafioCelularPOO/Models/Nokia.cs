namespace DesafioCelularPOO.Models
{
    public class Nokia : Smartphone
    {
        public Nokia(string numero, string modelo, string imei, int memoria) : base(numero, modelo, imei, memoria){
            NomeMarca = "Nokia";
        }

        public override void InstalarAplicativo(string nomeApp)
        {
            Console.WriteLine($"Instalando aplicativo \'{nomeApp}\' no Nokia.");
        }
    }
}