package util;

import modelo.Financiamento;
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.FileWriter;
import java.io.IOException;


public class InterfaceUsuario implements metodos_adicionais_entrada {
    public double usuarioValorImovel;
    public int usuarioPrazoFinanciamento;
    public double usuarioTaxadeJuros;

    // lista de financiamentos
    public ArrayList<Financiamento> listaDeFinanciamentos;

    // metodo construtor
    public InterfaceUsuario (double fornecidoUsuarioValor, int fornecidoUsuarioPrazo, double fornecidoUsuarioTaxa) {
        this.usuarioValorImovel = fornecidoUsuarioValor;
        this.usuarioPrazoFinanciamento = fornecidoUsuarioPrazo;
        this.usuarioTaxadeJuros = fornecidoUsuarioTaxa;
        this.listaDeFinanciamentos = new ArrayList<>();

    }

    //metodo para adicionar um financiamento a lista do usuario
    public void adicionarFinanciamentoaListaUsuario(Financiamento financiamento) {
        this.listaDeFinanciamentos.add(financiamento);
    }

        // metodos
    public double pedirvalor() {
        Scanner scanner = new Scanner(System.in);
        do {
            this.usuarioValorImovel = 0;
            System.out.print("Digite o valor do imóvel: ");
            try {
                this.usuarioValorImovel = scanner.nextDouble();
            } catch(InputMismatchException e) {
                System.out.println("Digite apenas números, ou descreva o valor corretamente, com casas decimais separadas por um ponto!");
                scanner.next();
            }
            if (usuarioValorImovel <= 0) {
                System.out.println("Valor inválido, digite novamente!");
                }
        } while (usuarioValorImovel <= 0);
            return this.usuarioValorImovel;
    }

    public int pedirPrazo() {
            Scanner scanner = new Scanner(System.in);
        do {
            this.usuarioPrazoFinanciamento = 0;
            System.out.print("Digite o prazo do financiamento em anos: ");
            try {
                this.usuarioPrazoFinanciamento = scanner.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("Digite apenas números inteiros!");
                scanner.next();
            }
                if (usuarioPrazoFinanciamento <= 0) {
                    System.out.println("Valor inválido, digite novamente!");
                }
        } while (usuarioPrazoFinanciamento <= 0);
        return this.usuarioPrazoFinanciamento;
    }
    public double pedirTaxa() {
            Scanner scanner = new Scanner(System.in);
        do {
            this.usuarioTaxadeJuros = 0;
            System.out.print("Digite a taxa de juros: ");
            try {
                this.usuarioTaxadeJuros = scanner.nextDouble();
            } catch(InputMismatchException e) {
                System.out.println("Digite apenas números, ou descreva o valor corretamente, com casas decimais separadas por um ponto!");
                scanner.next();
            }
                if (usuarioTaxadeJuros <= 0) {
                    System.out.println("Valor inválido. Digite novamente.");
                }
        } while (usuarioTaxadeJuros <= 0);
        return this.usuarioTaxadeJuros;
    }

    //metodos da interface
    public double atributos_adicionais_casa_area_construida() {
        double area = 0.0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Digite a area construída: ");
            try {
                area = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números, ou descreva o valor corretamente, com casas decimais separadas por um ponto!");
                scanner.next();
            }
                if (area <= 0) {
                    System.out.println("Valor inválido. Digite novamente.");
                }
        } while (area <= 0);
        return area;
    }
    public double atributos_adicionais_casa_tamanho_terreno(){
        double terreno = 0.0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Digite o tamanho do terreno: ");
            try {
                terreno = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números, ou descreva o valor corretamente, com casas decimais separadas por um ponto!");
                scanner.next();
            }
                if (terreno <= 0) {
                    System.out.println("Valor inválido. Digite novamente.");
                }
        } while (terreno <= 0);
        return terreno;
    }

    public int atributos_adicionais_apto_numero_vagas_garagem() {
        int vagas = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Digite a quantidade de vagas");
            try {
                vagas = scanner.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("Digite apenas números inteiros!");
                scanner.next();
            }

                if (vagas < 0) {
                    System.out.println("Valor inválido. Digite novamente.");
                }
        } while (vagas < 0);
        return vagas;
    }


    public int atributos_adicionais_apto_andar() {
        int andar = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Digite a area construída ");
            try {
                andar = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números, ou descreva o valor corretamente, com casas decimais separadas por um ponto!");
                scanner.next();
            }
                if (andar < 0) {
                    System.out.println("Valor inválido. Digite novamente.");
                }
        } while (andar < 0);
        return andar;
    }


    public boolean atributos_adicionais_terreno_tipo_uso() {
        boolean eresidencial = false;
        boolean entradaValida;
        Scanner scanner = new Scanner(System.in);
        do {
            entradaValida = true;
            System.out.print("É residencial ou comercial? (Se residencial digite 'true' e se comercial digite 'false': ");
            try {
                eresidencial = scanner.nextBoolean();
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas true ou false!");
                scanner.next();
                entradaValida = false;
            }
        } while (!entradaValida) ;
        return eresidencial;
    }


    //metodo toString para exibir os dados
    @Override
    public String toString(){
        return "Olá usário! Seu financiamento foi calculado com base nos valores fornecidos: Valor do imóvel R$" + usuarioValorImovel +". Prazo do Financiamento: " + usuarioPrazoFinanciamento + ". Taxa de Juros Anual: " + usuarioTaxadeJuros;
    }

    // salvando os arquivos em txt
    public void salvarArquivo(String nomeArquivo) {
        try (FileWriter escritor = new FileWriter(nomeArquivo)) {
            for (Financiamento a : listaDeFinanciamentos) {
                escritor.write(a.toString() + "\n");
            }
            System.out.println("Arquivo criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo" + e.getMessage());
        }
    }


        //serializando (escrevendo e salvando)
        public static void serializarFinanciamento (ArrayList <Financiamento> lista, String arquivo){
            try {
                ObjectOutputStream ser = new ObjectOutputStream(new FileOutputStream(arquivo));
                ser.writeObject(lista);
                ser.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //desserializando
        public static ArrayList<Financiamento> deserializarFinanciamento(String arquivo) {
            try (ObjectInputStream desser = new ObjectInputStream(new FileInputStream(arquivo))) {
                return (ArrayList<Financiamento>) desser.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erro ao desserializar: " + e.getMessage());
                return null;
            }
        }


    }


