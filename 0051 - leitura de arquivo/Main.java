import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        File file = new File("./arquivos/in.txt");
        Scanner sc = null;

        /*ao instanciar o arquivo, ocorre a tentativa de abertura, 
        por isso é necessário colocar dentro de um bloco try/catch*/
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        } 
        catch (IOException e){ //se der erro ao abrir o arquivo
            System.out.println("Erro: " + e.getMessage());
        }
        finally { //tem que fechar o scanner no finally pois se der erro ele não fecharia
            if (sc != null) { //tem que testar se o scanner foi preenchido
                sc.close();
            }
        }
    }
}