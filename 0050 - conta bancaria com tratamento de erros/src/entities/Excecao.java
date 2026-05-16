package src.entities;

public class Excecao extends Exception {

    public Excecao (String mensagem){
        super(mensagem);
    }

    public String getMensagem(){
        return super.getMessage();
    }
}