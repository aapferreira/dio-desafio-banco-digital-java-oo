/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labbancodigitaljavaoo;

/**
 *
 * @author aapferreira
 */
public class LabBancoDigitalJavaOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Cliente1");

        Conta cc = new ContaCorrente(cliente1);
        Conta poupanca = new ContaPoupanca(cliente1);
        Conta especial = new ContaEspecial(cliente1);

        cc.depositar(100);
        cc.transferir(50, poupanca);
        cc.transferir(100, poupanca);
        
        especial.depositar(30);
        especial.transferir(100, cc);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
        especial.imprimirExtrato();
    }

}
