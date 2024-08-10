package src;

public class Main {
    public static void main(String[] args){
        IPhone iphone = new IPhone();

        iphone.ligar("123");
        iphone.exibirPagina("google.com");
        iphone.tocar();
    }
}