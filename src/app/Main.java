package app;

import model.Pet;
import repository.FileRepository;
import services.PetEditor;
import services.PetListService;
import services.PetRegistrationService;
import services.PetSearchService;
import utils.PrintMenu;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        PrintMenu print = new PrintMenu();

        PetRegistrationService register = new PetRegistrationService();
        int option;


        do{
             option = print.printarMenu();

             switch (option){
                 case 1 -> register.registerPet();

                 case 2 -> PetEditor.searchEditor();

                 case 4 -> PetListService.listPets();

                 case 5-> PetSearchService.searchService();

                 case 6 -> {
                     System.out.println("Saindo...");
                     return;
                 }

                 default-> System.out.println("Inválido, tende novamente");

            }
        }while(option!=6);
    }
}