package app;

import model.Pet;
import repository.FileRepository;
import services.PetRegistrationService;
import utils.PrintMenu;

public class Main {
    public static void main(String[] args) {
        PrintMenu print = new PrintMenu();
        FileRepository arquivo = new FileRepository();
        int option = print.printarMenu();
        PetRegistrationService register = new PetRegistrationService();
        Pet pet = new Pet();


        do{
            if(option<=0){
                System.out.println("Inválido, tente novamente");
                print.printarMenu();
            }
            if(option ==1){
                register.registerPet();
              
                break;

            }
        }while(option!=6);





//       Pattern pattern = Pattern.compile("^[0-9]+$");


    }


}