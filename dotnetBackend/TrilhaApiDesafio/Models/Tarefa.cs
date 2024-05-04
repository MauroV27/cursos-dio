using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace TrilhaApiDesafio.Models
{
    public class Tarefa
    {
        public int Id { get; set; }
        public required string Titulo { get; set; }
        public required string Descricao { get; set; }
        public DateTime Data { get; set; }
        public EnumStatusTarefa Status { get; set; }

        public void Copia( Tarefa tarefa ){
            Titulo = tarefa.Titulo;
            Descricao = tarefa.Descricao;
            Data = tarefa.Data;
            Status = tarefa.Status;
        }
    }
}