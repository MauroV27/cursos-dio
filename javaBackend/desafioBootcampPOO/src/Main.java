import dominio.Bootcamp;
import dominio.Curso;
import dominio.Dev;
import dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nExecutando programa :");

        Curso curso1 = new Curso("Curso java", "Descrição do curso java", 12);
        Curso curso2 = new Curso("Curso Spring Boot", "Descrição do curso de Spring Boot", 18);

        Mentoria mentoria = new Mentoria("Mentoria de java", "Descrição da Mentoria java", LocalDate.now());

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer");

        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devMauro = new Dev("Mauro");
        devMauro.inscreverBootcamp(bootcamp);
        
        System.out.println("\nConteúdos Inscritos Mauro:" + devMauro.getConteudosInscritos());
        
        devMauro.progredir();
                
        System.out.println("\nConteúdos Inscritos Mauro:" + devMauro.getConteudosInscritos());
        System.out.println("\nConteúdos Concluídos Mauro:" + devMauro.getConteudosConcluidos());
        System.out.println("\n >> XP total de Mauro  :" + devMauro.calcularTotalXp());

        System.out.println("\n-------\n");

        Dev devCamila = new Dev("Camila");
        devCamila.inscreverBootcamp(bootcamp);

        System.out.println("\nConteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        
        devCamila.progredir();
        devCamila.progredir();
                
        System.out.println("\nConteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("\nConteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("\n >> XP total de Camila :" + devCamila.calcularTotalXp());

    }

}