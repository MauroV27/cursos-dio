namespace DesafioFundamentos.Models
{
    public class Estacionamento
    {
        private decimal precoInicial = 0;
        private decimal precoPorHora = 0;
        private List<string> veiculos = new List<string>();

        public Estacionamento(decimal precoInicial, decimal precoPorHora)
        {
            this.precoInicial = precoInicial;
            this.precoPorHora = precoPorHora;
        }

        private string PedePlacaVeiculo(string action){

            Console.WriteLine($"Digite a placa do veículo para {action}:");
            string? inputPlaca = Console.ReadLine();

            if ( inputPlaca == "" || inputPlaca == null ){
                return "";
            }

            return inputPlaca!;
        }

        public void AdicionarVeiculo()
        {
            string placa = this.PedePlacaVeiculo("estacionar");

            if (placa.Length == 0){
                Console.WriteLine("Necessário passar placa válida, por favor tente novamente.");
                return;
            }

            // Verifica se o veículo existe
            if ( veiculos.Any(x => x.ToUpper() == placa.ToUpper()) ){
                Console.WriteLine("O veículo já está cadastrado.");
                return;
            }

            veiculos.Add(placa);
            Console.WriteLine($"O veiculo {placa} foi adicionado com sucesso!");
        }

        public void RemoverVeiculo()
        {
            string placa = this.PedePlacaVeiculo("remover");

            if (placa.Length == 0){
                Console.WriteLine("Necessário passar placa válida, por favor tente novamente.");
                return;
            }

            // Verifica se o veículo existe
            bool veiculoExiste = veiculos.Any(x => x.ToUpper() == placa.ToUpper());
            if ( veiculoExiste == false ){
                Console.WriteLine("Desculpe, esse veículo não está estacionado aqui. Confira se digitou a placa corretamente");
                return;
            }
            
            Console.WriteLine("Digite a quantidade de horas que o veículo permaneceu estacionado:");

            // DONE: Pedir para o usuário digitar a quantidade de horas que o veículo permaneceu estacionado,
            string? inputHoras = Console.ReadLine();

            if (inputHoras == "" || inputHoras == null || int.TryParse(inputHoras, out int horas) == false || horas <= 0)
            {
                Console.WriteLine("Quantidade de horas inválida, operação de remoção de veículo cancelada.");
                return;
            }

            // DONE: Realizar o seguinte cálculo: "precoInicial + precoPorHora * horas" para a variável valorTotal     
            //Console.WriteLine($"{this.precoInicial} + ({this.precoPorHora} * {horas})");
            decimal valorTotal = this.precoInicial + (this.precoPorHora * horas);

            // DONE: Remover a placa digitada da lista de veículos
            veiculos.Remove(placa);

            Console.WriteLine($"O veículo {placa.ToUpper()} foi removido e o preço total foi de: R$ {valorTotal}");
        }

        public void ListarVeiculos()
        {
            // Verifica se há veículos no estacionamento
            if (veiculos.Any())
            {
                Console.WriteLine("Os veículos estacionados são:");
                
                // DONE: Realizar um laço de repetição, exibindo os veículos estacionados
                foreach (string veiculo in veiculos)
                {   
                    Console.WriteLine($" - {veiculo.ToUpper()}");
                }
            }
            else
            {
                Console.WriteLine("Não há veículos estacionados.");
            }
        }
    }
}