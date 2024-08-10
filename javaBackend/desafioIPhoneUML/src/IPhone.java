package src;

public class IPhone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {
    
    public IPhone(){}

    // @Override
    public void tocar(){
        System.out.println("IPhone está : " + "tocando música");
    }
    
    // @Override
    public void pausar(){
        System.out.println("IPhone está : " + "pausando música");
    }
    
    // @Override
    public void selecionarMusica(String musica){
        System.out.println("IPhone está : " + "selecionando música > " + musica);
    }

    
    // @Override
    public void ligar(String numero){
        System.out.println("IPhone está : " + "ligando para o número > " + numero);
    }
    
    // @Override
    public void atender(){
        System.out.println("IPhone está : " + "atendendo chamada");
    }
    
    // @Override
    public void finalizarChamada(){
        System.out.println("IPhone está : " + "finalizar chamada");
    }
    
    // @Override
    public void iniciarCorreioVoz(){
        System.out.println("IPhone está : " + "iniciar correio de voz");
    }

    
    // @Override
    public void exibirPagina(String url){
        System.out.println("IPhone está : " + "exibir páigna > " + url);
    }
    
    // @Override
    public void adicionarNovaAba(){
        System.out.println("IPhone está : " + "adicionar nova aba");
    }
    
    // @Override
    public void atualizarPagina(){
        System.out.println("IPhone está : " + "atualizando página");
    }
}


