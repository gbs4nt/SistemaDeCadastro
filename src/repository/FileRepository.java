package repository;

import java.io.*;
import java.nio.file.Files;

public class FileRepository {
    public void createFile() {
        File file = new File("C:\\Users\\Gabriel\\Documents\\Estudos\\DesafioCadastro\\desafioCadastro\\src\\data\\formulario.txt");
               try (FileWriter fw = new FileWriter(file, false);
                 BufferedWriter bw = new BufferedWriter(fw);) {
                bw.write("1 - Qual o nome do pet?");
                bw.newLine();
                bw.flush();
                bw.write("2 - Qual o tipo do pet(Cachorro/Gato)?");
                bw.newLine();
                bw.flush();
                bw.write("3 - Qual o sexo do animal?");
                bw.newLine();
                bw.flush();
                bw.write("4 - Qual endereço e bairro que ele foi encontrado?");
                bw.newLine();
                bw.flush();
                bw.write("5 - Qual a idade aproximada do pet?");
                bw.newLine();
                bw.flush();
                bw.write("6 - Qual o peso aproximado do pet?");
                bw.newLine();
                bw.flush();
                bw.write("7 - Qual a raça do pet? ");
                bw.newLine();
                bw.flush();


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public void readFile(){
            createFile();
        File file = new File( "C:\\Users\\Gabriel\\Documents\\Estudos\\DesafioCadastro\\desafioCadastro\\src\\data\\formulario.txt");


        try(FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr)){
            String linha;
                while((linha=br.readLine())!= null){
                    System.out.println(linha);
                }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        }
        public static String readSpecifyLine(int line){
        File file = new File("C:\\Users\\Gabriel\\Documents\\Estudos\\DesafioCadastro\\desafioCadastro\\src\\data\\formulario.txt");
        try(FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr)){
            String linha;
            int cont =1;
            while((linha= br.readLine())!=null){
                if(cont==line){
                    System.out.println(linha);
                }
                cont++;

            }
            return linha;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
}



