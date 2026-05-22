package modelo;

import util.AumentoMaiorDoQueJurosException;

import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final double seguro = 80.00;
    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double fornecidoValor, int fornecidoPrazo, double fornecidoTaxaAnual, double areaConstruida, double tamanhoTerreno){
        super(fornecidoValor, fornecidoPrazo, fornecidoTaxaAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public static double getSeguro() {
        return seguro;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    private void verificarAcrescimo() throws AumentoMaiorDoQueJurosException {
        double valorBaseMensal = this.getValorImovel() / (this.getPrazoFinanciamento() * 12);
        double jurosMensal = this.getTaxaJurosAnual() / 12;
        double valorJurosDaMensalidade = valorBaseMensal * jurosMensal;
        double acrescimo = 80.0;
        if (acrescimo > valorJurosDaMensalidade / 2) {
            throw new AumentoMaiorDoQueJurosException("O acréscimo de R$ 80,00 é maior que metade do valor dos juros da mensalidade."); }
    }

    @Override
    public double calcularPagamentoMensal() {
        try {
            verificarAcrescimo();
        } catch (AumentoMaiorDoQueJurosException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return (this.getValorImovel()/ (this.getPrazoFinanciamento() * 12)) * (1 + (this.getTaxaJurosAnual() / 12)) + 80.00;
    }


    @Override
    public double calculartotalPagamento() {
        return this.calcularPagamentoMensal() * this.getPrazoFinanciamento() * 12;
    }

    @Override
    public String toString() {
        return "Financiamento tipo casa: Os valores do financiamento são: \n 1 - valor do imóvel " + getValorImovel() + "\n 2 - Prazo: " + getPrazoFinanciamento() + "\n 3 - Taxa de juros anual: " + getTaxaJurosAnual();
    }
}
