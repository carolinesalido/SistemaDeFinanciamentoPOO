package modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String amortizacao = "amortização";
    private int numeroVagasGaragem;
    private int andar;

    public Apartamento(double fornecidoValor, int fornecidoPrazo, double fornecidoTaxaAnual, int numeroVagasGaragem, int andar) {
        super(fornecidoValor, fornecidoPrazo, fornecidoTaxaAnual);
        this.numeroVagasGaragem = numeroVagasGaragem;
        this.andar = andar;
    }

    public static String getAmortizacao() {
        return amortizacao;
    }

    public int getNumeroVagasGaragem() {
        return numeroVagasGaragem;
    }

    public int getAndar() {
        return andar;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = this.getTaxaJurosAnual() / 12.0;
        int meses = this.getPrazoFinanciamento() * 12;

        if (taxaMensal == 0) {
            return this.getValorImovel() / meses;
        }
        return (this.getValorImovel() * Math.pow(1 + taxaMensal, meses)) / (Math.pow(1 + taxaMensal, meses) - 1);
    }

    @Override
    public double calculartotalPagamento() {
        return this.calcularPagamentoMensal() * this.getPrazoFinanciamento() * 12;

    }

    @Override
    public String toString() {
        return "Financiamento tipo apartamento: Os valores do financiamento são: \n 1 - valor do imóvel " + getValorImovel() + "\n .2 - Prazo: " + getPrazoFinanciamento() + "\n .3 - Taxa de juros anual: " + getTaxaJurosAnual();
    }
}
