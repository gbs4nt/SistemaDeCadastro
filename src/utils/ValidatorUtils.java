package utils;

import model.Pet;
import model.PetGender;

import java.util.Scanner;

public class ValidatorUtils  {
    public static final String NAO_INFORMADO = "Não Informado";
    Scanner scanner = new Scanner(System.in);
    public String isValidName(Scanner scanner){
        try{
            String nomeFornecido = scanner.nextLine();
            Pet pet = new Pet();
            return pet.setPetName(nomeFornecido);


        }catch(IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage() + " Tente novamente");
            return isValidName(scanner);
        }
        }

    public int isValidType(Scanner scanner){

        int validType = scanner.nextInt();
        if (validType==1|| validType==2) {
            System.out.println("Entendido!");
            return validType;

            }else {
            System.out.println("Entrada inválida! Digite um número válido.");
            return isValidType(scanner);
        }

            }
    public int isValidGender(Scanner scanner) {

        int validGender = scanner.nextInt();

        if (validGender == 1 || validGender == 2) {
            System.out.println("Entendido!");
            return validGender;
        } else {

            System.out.println("Entrada inválida! Digite um número válido.");
            scanner.nextLine();
            return isValidGender(scanner);
        }
    }
    public String isValidHouseNumber(Scanner scanner){
        try{
            String number = scanner.nextLine();
            if(!number.matches("[0-9]+")){
                throw new IllegalArgumentException("Informação inválida, tente novamente.");
            }else{
                System.out.println("Entendi!");
            }
            return number;


        }catch (IllegalArgumentException e){
            System.out.println("Erro: "+e.getMessage());
            return isValidHouseNumber(scanner);
        }

    }


    }











