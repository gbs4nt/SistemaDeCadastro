package services;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class PetDelete {
    public static void petDeleteSearchType(){

            Scanner scanner = new Scanner(System.in);
            System.out.println("Qual tipo de pet deseja buscar?");
            System.out.println("1 - Cachorro");
            System.out.println("2 - Gato");
            String tipoEscolhido = scanner.nextLine();

            String tipoPet;
            if (tipoEscolhido.equals("1")) {
                tipoPet = "Cachorro";

            } else if (tipoEscolhido.equals("2")) {
                tipoPet = "Gato";
            } else {
                System.out.println("Tipo inválido");
                return;
            }

            File dir = new File("C:\\Users\\Gabriel\\Documents\\Estudos\\DesafioCadastro\\desafioCadastro\\src\\registredPets");
            File[] arquivos = dir.listFiles();
            if (arquivos == null) {
                System.out.println("Nenhum arquivo encontrado");
                return;
            }
            List<File> arquivosDoTipo = new ArrayList<>();

            for (File arquivo : arquivos) {
                if (arquivo.isFile()) {
                    try (Scanner fileScanner = new Scanner(arquivo)) {
                        while (fileScanner.hasNextLine()) {
                            String linha = fileScanner.nextLine();
                            if (linha.contains("Tipo: " + tipoPet)) {
                                arquivosDoTipo.add(arquivo);
                                break;
                            }// Se a linha contiver "Tipo: " seguido da escolha do usuário (tipoPet),
                            // o arquivo será adicionado à lista de arquivos do tipo selecionado (arquivosDoTipo),
                            // usando a variável de referência "arquivo".
                        }

                    } catch (Exception e) {
                        System.out.println("Erro ao ler o arquivo: " + arquivo.getName());
                    }
                }
            }
            System.out.println("\nPets do tipo " + tipoPet + " encontrados: ");
            for (File petFile : arquivosDoTipo) {
                System.out.println("- " + petFile.getName());
            }
            System.out.println("    ");
            searchByCriteriaDelete(arquivosDoTipo);

        }

        public static void searchByCriteriaDelete(List<File> arquivosDoTipo) {
            Scanner scanner = new Scanner(System.in);
            List<String> criteriosEscolhidos = new ArrayList<>();

            System.out.println("Você pode escolher até 3 critérios de busca: ");
            System.out.println("Critérios disponíveis: nome, idade, peso, raça,gênero e endereço ");

            for (int i = 0; i < 3 && i >= 0; i++) {
                System.out.println("Digite o critério desejado(Pressione ENTER para pular)");
                String criterio = scanner.nextLine().trim().toLowerCase();

                if (criterio.isEmpty()) {
                    break;
                }
                if (criterio.equals("nome") || criterio.equals("idade") || criterio.equals("peso") || criterio.equals("raça") || criterio.equals("endereço") || criterio.equals("gênero")) {
                    if (!criteriosEscolhidos.contains(criterio)) {
                        criteriosEscolhidos.add(criterio);
                    } else {
                        System.out.println("Você ja escolheu esse critério.");
                    }
                } else {
                    System.out.println("Critério inválido");
                    i--;
                }
            }
            Map<String, String> valoresCriterios = new HashMap<>();
            for (String criterio : criteriosEscolhidos) {
                System.out.println("Digite o valor desejado para " + criterio + ":");
                String valor = scanner.nextLine().trim();
                valoresCriterios.put(criterio, valor);
            }
            filtrarPorCriteriosEditor(arquivosDoTipo, valoresCriterios);

        }

        private static void filtrarPorCriteriosEditor(List<File> arquivosdoTipo, Map<String, String> criterios) {

            Map<Integer, File> mapaNumeros = new HashMap<>();
            int numeroPet = 1;
            for (File arquivo : arquivosdoTipo) {
                boolean atendeTodos = true;

                try (Scanner fileScanner = new Scanner(arquivo)) {

                    List<String> conteudo = new ArrayList<>();
                    while (fileScanner.hasNextLine()) {
                        conteudo.add(fileScanner.nextLine());
                    }
                    for (Map.Entry<String, String> criterio : criterios.entrySet()) {
                        String campo = criterio.getKey();
                        String valor = criterio.getValue().toLowerCase();

                        boolean achou = false;
                        for (String linha : conteudo) {
                            if (linha.toLowerCase().startsWith(campo + ":") && linha.toLowerCase().contains(valor)) {
                                achou = true;
                                break;
                            }
                        }
                        if (!achou) {
                            atendeTodos = false;
                            break;
                        }
                    }
                    if (atendeTodos) {
                        System.out.println("Pet número: " + numeroPet);
                        for (String linha : conteudo) {
                            System.out.println(linha);
                        }
                        System.out.println("------------------------------------------------");
                    }
                    mapaNumeros.put(numeroPet, arquivo);
                    numeroPet++;
                } catch (IOException e) {
                    System.out.println("Erro ao ler o arquivo: " + arquivo.getName());
                }
            }
            deletePet(arquivosdoTipo, mapaNumeros);
        }
        private static void deletePet(List<File> arquivosDoTipo, Map<Integer, File> mapaNumeros){
        Scanner scanner = new Scanner(System.in);
            System.out.println("Digite com base no número qual pet você deseja deletar.");
            int index = scanner.nextInt();

            File arquivoEscolhido = mapaNumeros.get(index);
            while(!mapaNumeros.containsKey(index)){
                System.out.println("Número inválido, digite outro.");
                System.out.println("Digite com base no número qual pet você deseja deletar.");
                index = scanner.nextInt();
                scanner.nextLine();
                arquivoEscolhido = mapaNumeros.get(index);
            }
            try{
            arquivoEscolhido.delete();

        }catch(Exception e){
                e.getStackTrace();
    }
    }
}
