namespace DesafioHospedes.Models
{
    public class Reserva
    {
        public List<Pessoa> Hospedes { get; set; }
        public Suite? Suite { get; set; }
        public int DiasReservados { get; set; }

        public Reserva() { 
            Suite = null;
            Hospedes = new List<Pessoa>();
        }

        public Reserva(int diasReservados)
        {
            Suite = null;
            Hospedes = new List<Pessoa>();
            DiasReservados = diasReservados;
        }

        public void CadastrarHospedes(List<Pessoa> hospedes)
        {

            // Verficar se Suite foi atribuido : 
            if ( Suite is null ){
                throw new NullReferenceException("Necessário setar a Suite da Reserva!");
            }

            // TODO: Verificar se a capacidade é maior ou igual ao número de hóspedes sendo recebido
            if ( hospedes.Count <= Suite.Capacidade )
            {
                Hospedes = hospedes;
            }
            else
            {
                // TODO: Retornar uma exception caso a capacidade seja menor que o número de hóspedes recebido
                throw new ArgumentOutOfRangeException("Número de hóspedes excedeu a capacidade da suite!");
            }
        }

        public void CadastrarSuite(Suite suite)
        {
            Suite = suite;
        }

        public int ObterQuantidadeHospedes()
        {
            // TODO: Retorna a quantidade de hóspedes (propriedade Hospedes)
            return Hospedes.Count;
        }

        public decimal CalcularValorDiaria()
        {
            // Verficar se Suite foi atribuido : 
            if ( Suite is null ){
                throw new NullReferenceException("Necessário setar a Suite da Reserva!");
            }

            // Cálculo: DiasReservados X Suite.ValorDiaria        
            decimal valor = DiasReservados * Suite.ValorDiaria;

            // Regra: Caso os dias reservados forem maior ou igual a 10, conceder um desconto de 10%
            if ( DiasReservados >= 10 )
            {
                valor = valor * 0.9M;
            }

            return valor;
        }
    }
}