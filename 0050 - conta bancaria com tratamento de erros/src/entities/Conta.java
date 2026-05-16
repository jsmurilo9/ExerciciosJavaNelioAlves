package src.entities;

public class Conta {
    private Integer numero;
    private String titular;
    private Double saldo;
    private Double limite;

    public Conta(){}

    public Conta(Integer numero, String titular){
        this.numero = numero;
        this.titular = titular;
    }

    public Conta(Integer numero, String titular, Double saldo, double limite){
        this(numero,titular);
        this.saldo = saldo;
        this.limite = limite;
    }

    public Double sacar(Double valor) throws Excecao{
        if (valor == null){
            throw new Excecao("Valor do saque não pode ser nulo");
        }
        if (valor <= 0){
            throw new Excecao("Valor do saque deve ser maior que zero");
        }
        if (valor > (saldo + limite)){
            throw new Excecao("Saldo insuficiente e limite superado");
        }
        this.saldo -= valor;
        return this.saldo;
    }

    public double depositar(Double valor) throws Excecao{
        if (valor == null){
            throw new Excecao("Valor do depósito não pode ser nulo");
        }
        if (valor <= 0){
            throw new Excecao("Valor do depósito deve ser maior que zero");
        }
        this.saldo += valor;
        return this.saldo;
    }

    @Override
    public String toString(){
        return  "\n*** Dados da conta ***" + 
                "\nNumero: " + this.numero + "\n" + 
                "Titular: " + this.titular + "\n" + 
                String.format("Saldo: R$ %.2f%n",this.saldo) +
                String.format("Limite: R$ %.2f%n",this.limite) + 
                String.format("Total Disponível (saldo+limite): R$ %.2f%n",this.limite+this.saldo);
    }

}
