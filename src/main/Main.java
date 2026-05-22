
package main;
import modelo.Financiamento;
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao Sistema de Financiamento do Banco da Carol.");
        // objetos da classe interface usuario
        InterfaceUsuario usuario1 = new InterfaceUsuario(0.0, 0, 0.0);

        // iniciando arquivo txt
        String arquivo = "financiamentos.txt";



        //implementando o arquivo para serializar

        String arquivoSER = "financiamentos.ser";


        System.out.println("----Financiamento 1---- (Casa)");
        // coletar os dados da classe
        usuario1.pedirvalor();
        usuario1.pedirPrazo();
        usuario1.pedirTaxa();


        // objeto da classe financiamento tipo casa
        Casa financiamento1 = new Casa(usuario1.usuarioValorImovel, usuario1.usuarioPrazoFinanciamento, usuario1.usuarioTaxadeJuros, usuario1.atributos_adicionais_casa_area_construida(), usuario1.atributos_adicionais_casa_tamanho_terreno());

        //adicionar o financiamento a lista
        usuario1.adicionarFinanciamentoaListaUsuario(financiamento1);


        // usar os metodos do financiamento
        double parcelaMensalusuario1 = financiamento1.calcularPagamentoMensal();
        double totalPagamentousuario1 = financiamento1.calculartotalPagamento();

        System.out.println(financiamento1);
        System.out.println("A parcela mensal será de: " + parcelaMensalusuario1 + " e o pagamento total será de: " + totalPagamentousuario1);

        System.out.println("----Financiamento 2---- (Apartamento)");

        Apartamento financiamento2 = new Apartamento(345.768, 45, 3, 2, 4);

        usuario1.adicionarFinanciamentoaListaUsuario(financiamento2);

        double parcelaMensalusuario2 = financiamento2.calcularPagamentoMensal();
        double totalPagamentousuario2 = financiamento2.calculartotalPagamento();


        System.out.println(financiamento2);
        System.out.println("A parcela mensal será de: " + parcelaMensalusuario2 + " e o pagamento total será de: " + totalPagamentousuario2);

        System.out.println("----Financiamento 3---- (Apartamento)");

        Apartamento financiamento3 = new Apartamento(234.000, 30, 2, 3, 6);

        usuario1.adicionarFinanciamentoaListaUsuario(financiamento3);

        double parcelaMensalusuario3 = financiamento3.calcularPagamentoMensal();
        double totalPagamentousuario3 = financiamento3.calculartotalPagamento();
        System.out.println("A parcela mensal será de: " + parcelaMensalusuario3 + " e o pagamento total será de: " + totalPagamentousuario3);


        System.out.println(financiamento3);

        System.out.println("----Financiamento 4----(Terreno)");

        Terreno financiamento4 = new Terreno(150.000, 15, 2, true);

        usuario1.adicionarFinanciamentoaListaUsuario(financiamento4);

        double parcelaMensalusuario4 = financiamento4.calcularPagamentoMensal();
        double totalPagamentousuario4 = financiamento4.calculartotalPagamento();


        System.out.println(financiamento4);
        System.out.println("A parcela mensal será de: " + parcelaMensalusuario4 + " e o pagamento total será de: " + totalPagamentousuario4);

        System.out.println("-----------Resumo dos 4 financiamentos----------- ");
        System.out.println("Financiamento 1: " + financiamento1);
        System.out.println("Financiamento 2: " + financiamento2);
        System.out.println("Financiamento 3: " + financiamento3);
        System.out.println("Financiamento 4: " + financiamento4);
        System.out.println("O valor total dos 4 imóveis é de: R$" + (financiamento1.getValorImovel() + financiamento2.getValorImovel() + financiamento3.getValorImovel() + financiamento4.getValorImovel()));
        System.out.println("O valor total dos 4 financiamentos é de: R$" + (totalPagamentousuario1 + totalPagamentousuario2 + totalPagamentousuario3 + totalPagamentousuario4));



        // salvando em txt
        usuario1.salvarArquivo(arquivo);

        // serializando

        InterfaceUsuario.serializarFinanciamento(usuario1.listaDeFinanciamentos,arquivoSER);
        System.out.println("Financiamentos salvo e serializados no arquivo " + arquivoSER);


        // desserializando
        System.out.println("Financiamento tentando ser desserializado...");
        ArrayList<Financiamento> lista = InterfaceUsuario.deserializarFinanciamento(arquivoSER);
        if (lista != null) {
            System.out.println("Financiamentos desserializados:");
            for (Financiamento f : lista) {
                System.out.println(f);
            }
        }


        }
}

