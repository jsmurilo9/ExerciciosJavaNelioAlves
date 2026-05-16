import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main{

    /*o bloco trywithresources está disponível a partir da versão 7
    do java e garante que os recursos serão fechados ao final do bloco*/
    public static void main(String[] args) {
        String caminho = "./arquivos/in.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))){
            String linha = br.readLine();
            while (linha != null){
                System.out.println(linha);
                linha = br.readLine();
            }
        } catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }

    }
}