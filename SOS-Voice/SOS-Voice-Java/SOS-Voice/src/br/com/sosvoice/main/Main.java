package br.com.sosvoice.main;

import br.com.sosvoice.bean.Ocorrencia;
import br.com.sosvoice.bean.OcorrenciaGrave;
import br.com.sosvoice.bean.LocalRisco;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SOS Voice – Sistema de Simulação de Ocorrências ===");

        try {
            System.out.print("Informe o tipo de ocorrência (Ex: Incêndio, Enchente, Deslizamento): ");
            String tipo = scanner.nextLine();

            System.out.print("Informe o local da ocorrência: ");
            String local = scanner.nextLine();

            // Validação da urgência
            String urgencia;
            do {
                System.out.print("Informe o nível de urgência (Baixo / Médio / Alto): ");
                urgencia = scanner.nextLine().trim();
                if (!urgencia.equalsIgnoreCase("Baixo") &&
                        !urgencia.equalsIgnoreCase("Médio") &&
                        !urgencia.equalsIgnoreCase("Alto")) {
                    System.out.println("⚠️ Valor inválido. Digite: Baixo, Médio ou Alto.");
                }
            } while (!urgencia.equalsIgnoreCase("Baixo") &&
                    !urgencia.equalsIgnoreCase("Médio") &&
                    !urgencia.equalsIgnoreCase("Alto"));

            System.out.print("A ocorrência é grave? (s/n): ");
            String resposta = scanner.nextLine();

            Ocorrencia ocorrencia;

            if (resposta.equalsIgnoreCase("s")) {
                System.out.print("Digite a recomendação de segurança: ");
                String recomendacao = scanner.nextLine();
                ocorrencia = new OcorrenciaGrave(tipo, local, urgencia, recomendacao);
            } else {
                ocorrencia = new Ocorrencia(tipo, local, urgencia);
            }

            System.out.println("\n--- Resumo da Ocorrência ---");
            System.out.println(ocorrencia); // toString() precisa estar implementado na classe

            System.out.print("\nDeseja cadastrar este local como área de risco? (s/n): ");
            String cadastrar = scanner.nextLine();

            if (cadastrar.equalsIgnoreCase("s")) {
                LocalRisco risco = new LocalRisco(local, true);
                System.out.println(risco); // toString() também aqui
            } else {
                System.out.println("Local não registrado como área de risco.");
            }

        } catch (InputMismatchException e) {
            System.out.println("⚠️ Tipo de entrada inválido.");
        } catch (NullPointerException e) {
            System.out.println("⚠️ Algum valor necessário não foi informado.");
        } catch (Exception e) {
            System.out.println("⚠️ Erro inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
