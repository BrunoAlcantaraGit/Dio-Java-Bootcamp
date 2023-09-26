package src.java;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    double salarioBase = 2000;

    public void analisarCandidato(double salarioPretendido) {
        if (this.salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        } else {
            System.out.println("Aguardando resultado demais candidatos");
        }

    }
    public void selecaodeCandidato(){
        String [] candidatos = {"Felipe", "Marcia", "Júlia", "Paulo", "Augusto","Monica","Fabricio","Mirela","Daniela","José" };
        int candidatosSelecionados = 0;
        int canditadoAtual = 0;
        double salarioBase = 2000;

        while (candidatosSelecionados < 5 && canditadoAtual < candidatos.length){
            String candidato = candidatos[canditadoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("___________________________________________________________");
                System.out.println("O candito " + candidato + " Foi selecionando para a vaga ");
                analisarCandidato(salarioPretendido);
                System.out.println("_____________________________________________________________");
                candidatosSelecionados++;
            }
            canditadoAtual++;

        }
    }
    public   double valorPretendido (){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }


    public void listarTentativaDeContato(){
        String [] candidatos = {"Felipe", "Marcia", "Júlia", "Paulo", "Augusto"};
        for (String candidato:candidatos) {
        entrandoEmContato(candidato);
        }
    }

    public void entrandoEmContato(String candidato){
        int  tentativasRealizadas = 1;
        boolean contunuaTentando = true;
        boolean atendeu = false;
        do{
        atendeu = atender();
        contunuaTentando = !atendeu;
        if(contunuaTentando){
            tentativasRealizadas++;
        }else {
            System.out.println("CONTATO REALIZADO COM SUCESSO");
        }
        }while (contunuaTentando && tentativasRealizadas < 3);

        if(atendeu){
            System.out.println("Conseguimos contato com "+ candidato + " Na " + tentativasRealizadas + " Tentativas " );
        }else {
            System.out.println("Não Conseguimos contato com "+ candidato + " Numero máximo de tentativas " + tentativasRealizadas + "Realizadas " );

        }
    }

    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }
}
