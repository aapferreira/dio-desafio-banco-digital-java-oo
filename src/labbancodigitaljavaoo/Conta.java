package labbancodigitaljavaoo;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {

        if ((this.getSaldo() - valor) < 0) {
            operacaoNaoRealizada(valor);
        } else {
            efetuarTransferencia(valor, contaDestino);
        }

    }

    private void efetuarTransferencia(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        operacaoRealizada(valor);
    }

    protected void operacaoRealizada(double valor) {
        System.out.println("Transferência realizada com sucesso: R$ "
                + String.format("%.2f", valor)
                + " para "
                + this.cliente.getNome());
        System.out.println();
    }

    protected void operacaoNaoRealizada(double valor) {
        System.out.println("Seu saldo atual é de R$ "
                + String.format("%.2f", this.getSaldo())
                + " e é insuficiente para a transferência de "
                + String.format("R$ %.2f", valor)
                + " para "
                + this.cliente.getNome());
        System.out.println();
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println("=== Fim do Extrato ===");
        System.out.println();
    }
}
