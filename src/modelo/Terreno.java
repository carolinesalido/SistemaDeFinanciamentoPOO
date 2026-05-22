package modelo;
import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final double acrescimo = 2.0;
    private boolean tipoDeUso;

    public Terreno(double fornecidoValor, int fornecidoPrazo, double fornecidoTaxaAnual, boolean tipoDeUso) {
        super(fornecidoValor, fornecidoPrazo, fornecidoTaxaAnual);
        this.tipoDeUso = tipoDeUso;
    }

    public static double getAcrescimo() {
        return acrescimo;
    }

    public boolean getTipoDeUso() {
        return tipoDeUso;
    }

    @Override
    public double calcularPagamentoMensal() {
        return (this.getValorImovel()/ (this.getPrazoFinanciamento() * 12)) * (1 + (this.getTaxaJurosAnual() / 12)) * (1 + acrescimo / 100);
    }

    @Override
    public double calculartotalPagamento() {
        return this.calcularPagamentoMensal() * this.getPrazoFinanciamento() * 12;

    }

    @Override
    public String toString() {
        return "Financiamento tipo terreno: Os valores do financiamento são: \n 1 - valor do imóvel " + getValorImovel() + "\n 2 - Prazo: " + getPrazoFinanciamento() + "\n 3 - Taxa de juros anual: " + getTaxaJurosAnual();
    }
}
