package modelo;
import java.io.Serializable;

public abstract class Financiamento implements Serializable {
        // atributos
        private static final long serialVersionUID = 1L;
        private double valorImovel;
        private int prazoFinanciamento;
        private double taxaJurosAnual;

        // metodo construtor
        public Financiamento(double fornecidoValor, int fornecidoPrazo, double fornecidoTaxaAnual) {
            this.valorImovel = fornecidoValor;
            this.prazoFinanciamento = fornecidoPrazo;
            this.taxaJurosAnual = fornecidoTaxaAnual;
        }

        //metodos get

        public double getValorImovel() {
            return valorImovel;
        }

        public int getPrazoFinanciamento() {
            return prazoFinanciamento;
        }

        public double getTaxaJurosAnual() {
            return taxaJurosAnual;
        }
        //metodo toString para imprimir os valores
        public String toString() {
            return "Os valores do financiamento são: \n 1 - valor do imóvel " + getValorImovel() + "\n .2 - Prazo: " + getPrazoFinanciamento() + "\n .3 - Taxa de juros anual: " + getTaxaJurosAnual();
        }
    // metodos

    public abstract double calcularPagamentoMensal();

    public double calculartotalPagamento() {
        return this.calcularPagamentoMensal() * this.getPrazoFinanciamento() * 12;

    }

}
