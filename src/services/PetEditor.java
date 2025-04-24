package services;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class PetEditor {
    public static void alterarDados(List<File> arquivosDoTipo, Map<Integer, File> mapaNumeros){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja alterar os dados de um dos pets? Se sim, diga qual através do número.");
        int index = scanner.nextInt();
        scanner.nextLine();
        File arquivoEscolhido = mapaNumeros.get(index);

        System.out.println("Escolha qual atributo você deseja alterar do(a) pet "+arquivoEscolhido.getName());
        String campo = scanner.nextLine();

        System.out.println("Agora, escolha o que deseja mudar no campo "+campo);
        String valor = scanner.nextLine();

        Map<String, String> valorAlterado = new HashMap<>();
        valorAlterado.put(campo, valor);

        for(File arquivo: arquivosDoTipo) {
            boolean achou = false;
            try(Scanner fileScanner = new Scanner(arquivo)){
                List<String> conteudo = new ArrayList<>();
                while (fileScanner.hasNextLine()) {
                    conteudo.add(fileScanner.nextLine());
                }


                for (int i = 0; i < conteudo.size(); i++) {
                    String linha = conteudo.get(i);
                    if (linha.toLowerCase().startsWith(campo.toLowerCase() + ":")) {
                        conteudo.set(i, campo + ": " + valor);
                        achou = true;
                        break;
                    }
                }
                if(achou){
                    try(PrintWriter pw = new PrintWriter(arquivoEscolhido)) {
                        for (String linha : conteudo) {
                            pw.println(linha);
                        }
                    }
                }

                System.out.println("Alteração feita com sucesso no arquivo "+arquivoEscolhido.getName());

            }
            catch(Exception e){
                System.out.println("Erro ao ler o arquivo "+arquivo.getName());
            }
        }



    }

    public static void alterarDados() {
    }
}
