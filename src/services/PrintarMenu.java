package services;

import java.util.Scanner;

public class PrintarMenu {
    public int printarMenu() {
        Scanner resposta = new Scanner(System.in);
        System.out.println("1. Cadastrar um novo pet\n" + "2. Alterar os dados do pet cadastrado\n3. Deletar um pet cadastrado\n4. Listar todos os pets cadastrados\n5. Listar pets por algum critério (idade, nome, raça)\n6. Sair\n");
       int opcao = resposta.nextInt();
        return opcao;
    }

    public static int numberInRange(Scanner resposta) {
            if (resposta.hasNextInt()) {
                int num = resposta.nextInt();
                resposta.nextLine();

                } else {
                    System.out.println("Inválido.");
                 }
        return 0;
    }

    }


