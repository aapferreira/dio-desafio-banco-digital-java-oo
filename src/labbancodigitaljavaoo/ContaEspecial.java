package labbancodigitaljavaoo;

public class ContaEspecial extends Conta {

    public ContaEspecial(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Especial ===");
        super.imprimirInfosComuns();
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        super.operacaoRealizada(valor);
    }

}
