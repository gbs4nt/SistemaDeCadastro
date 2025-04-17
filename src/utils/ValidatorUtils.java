package utils;

import model.Pet;
import model.PetGender;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class ValidatorUtils  {
    public static final String NAO_INFORMADO = "Não Informado";
    Scanner scanner = new Scanner(System.in);
    public String isValidName(Scanner scanner){
        try{
            String nomeFornecido = scanner.nextLine();
            Pet pet = new Pet();
            return pet.setPetName(nomeFornecido);


        }catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + " try again");
            return isValidName(scanner);
        }
        }

    public int isValidType(Scanner scanner) {
        try {
            int validType = scanner.nextInt();
            if (validType == 1 || validType == 2) {

                return validType;
            }else{
                System.out.println("Please, enter 1 or 2.");
                return isValidType(scanner);
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
            return isValidType(scanner);
        }


    }
    public int isValidGender(Scanner scanner) {

        try{
        int validGender = scanner.nextInt();
        if (validGender == 1 || validGender == 2) {

            return validGender;
        }else {
            System.out.println("Invalid! Type a valid number.");
            scanner.nextLine();
            return isValidGender(scanner);
        }
        }catch (InputMismatchException e){
            System.out.println("Error: "+e.getMessage());
            return isValidGender(scanner);
        }
    }
    public String isValidHouseNumber(Scanner scanner){
        try{
            String number = scanner.nextLine();
            if(!number.matches("[0-9]+")){
                throw new IllegalArgumentException("Invalid information, try again.");
            }else{
                return number;
            }
        }catch (IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
            return isValidHouseNumber(scanner);
        }

    }

    public String isValidCity(Scanner scanner){
        try{
            String city = scanner.nextLine();
            if(!city.matches("[a-zA-Z ]+")){
                throw new IllegalArgumentException("Just letters and spaces , please.");
            }else{
                return city;
            }
        }catch(IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
            return isValidCity(scanner);
        }
    }
    public String isValidStreet(Scanner scanner){
            try{
                String street = scanner.nextLine();
                if(!street.matches("[a-zA-Z ]+" )){
                    throw new IllegalArgumentException("Just Letters and spaces, please");
                }else{
                    return street;
                }
        }catch (IllegalArgumentException e ){
                System.out.println("Error: "+e.getMessage());
                return isValidStreet(scanner);
            }
    }
    public String isValidAge(Scanner scanner){
        try{
            String age = scanner.nextLine();

            if(parseDouble(age)>20){
                System.out.println("Values above 20 isn't allowed.");
                return isValidAge(scanner);

            }
            if(age.contains(",")){
                age.replace(",", ".");
            }  return age;

        }catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return isValidAge(scanner);
        }

    }

    public String isValidWeight(Scanner scanner){
        String weight = scanner.nextLine();
            try {
                boolean isValid = parseDouble(weight)  > 0.5 && parseDouble(weight) < 60;
                if(!isValid){
                    System.out.println("The weight isn't allowed to be above 60 and less than 0.5 ");
                    return isValidWeight(scanner);
                }
                if(weight.contains(",")){
                   weight.replace(",", ".");
                }
            }
            catch (Exception e) {
                System.out.println("Error catch : " + e.getMessage());
            }
        return weight;


    }
    public String isValidBreed(Scanner scanner){
        String breed = scanner.nextLine();
        try{
            boolean isValid = breed.matches("[a-zA-Z ]+");
            if(!isValid){
                System.out.println("Just letters, please.");
                return isValidBreed(scanner);
            }

        }catch (IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
        }
        return breed;

    }


}











