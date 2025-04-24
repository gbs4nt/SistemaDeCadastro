package services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PetListService {
    public static void listPets(){
        File dir = new File("C:\\Users\\Gabriel\\Documents\\Estudos\\DesafioCadastro\\desafioCadastro\\src\\registredPets");
        File[] arquivos = dir.listFiles();
        if(arquivos==null){
            System.out.println("Nenhum arquivo encontrado");
            return;
        }

        List<File> pets = new ArrayList<>();

        for(File arquivo: arquivos){
            if(arquivo.getName().endsWith(".txt")){
                pets.add(arquivo);
            }
        }
        for(File petlist:pets){
            System.out.println(petlist.getName());
        }
    }
}
