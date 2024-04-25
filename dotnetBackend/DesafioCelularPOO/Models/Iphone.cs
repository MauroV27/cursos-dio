namespace DesafioCelularPOO.Models
{
    public class Iphone : Smartphone
    {
        public Iphone(string numero, string modelo, string imei, int memoria) : base(numero, modelo, imei, memoria) {
            NomeMarca = "Iphone";
        }

        public override void InstalarAplicativo(string nomeApp)
        {
            Console.WriteLine($"Instalando aplicativo \'{nomeApp}\' no IPhone.");
        }
    }
}