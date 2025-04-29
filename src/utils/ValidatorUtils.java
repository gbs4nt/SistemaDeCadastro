package utils;

import model.Pet;
import model.PetGender;
import model.PetType;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class ValidatorUtils  {
    Scanner scanner = new Scanner(System.in);
    public String isValidName(Scanner scanner){
        try{
            String nomeFornecido = scanner.nextLine();
            Pet pet = new Pet();
            return pet.setPetName(nomeFornecido);


        }catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + " tente novamente");
            return isValidName(scanner);
        }
        }

    public int isValidType(Scanner scanner) {
        try {
            int validType = scanner.nextInt();
            scanner.nextLine();
            if (validType == 1 || validType == 2) {
                return validType;
            }else{
                System.out.println("Por favor, digite 1 ou 2.");

                return isValidType(scanner);
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());

            return isValidType(scanner);
        }


    }
    public int isValidGender(Scanner scanner) {


                String input = scanner.nextLine();
                if(input.isEmpty()){
                    return 0;
                }

        try{
                int validGender =Integer.parseInt(input);
        if (validGender == 1 || validGender == 2) {

            return validGender;
        }else {
            System.out.println("Inválido! Digite um número.");
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
            if(number.trim().isEmpty()){
                return null;
            }
            if(!number.matches("[0-9]+")){
                throw new IllegalArgumentException("Informação inválida, tente novamente..");
            }else{
                return number;
            }
        }catch (IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
            return isValidHouseNumber(scanner);
        }

    }

    public String isValidCity(Scanner scanner){
        String city = scanner.nextLine();
        if(city.isEmpty()){
            return null;
        }
        try{

            if(!city.matches("[a-zA-Z ]+")){
                throw new IllegalArgumentException("Apenas números,espaços e letras, por favor");
            }else{
                return city;
            }
        }catch(IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
            return isValidCity(scanner);
        }
    }
    public String isValidStreet(Scanner scanner){
        String street = scanner.nextLine();
        if(street.isEmpty()){
            return null;
        }
            try{

                if(!street.matches("[a-zA-Z0-9 ]+" )){
                    throw new IllegalArgumentException("Apenas números,espaços e letras, por favor");
                }else{
                    return street;
                }
        }catch (IllegalArgumentException e ){
                System.out.println("Error: "+e.getMessage());
                return isValidStreet(scanner);
            }
    }
    public Double isValidAge(Scanner scanner){
        double age = scanner.nextDouble();
        scanner.nextLine();
        try{
            if(age>20){
                System.out.println("Valores acima de 20 não são permitidos.");
                return isValidAge(scanner);
            }
        }catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return isValidAge(scanner);
        }
        return age;
    }

    public String isValidWeight(Scanner scanner){
        String weight = scanner.nextLine();
        if(weight.isEmpty()){
            return null;
        }
        try {
            if(weight.contains(",")){
                weight = weight.replace(",", ".");
            }
            boolean isValid = parseDouble(weight)  > 0.5 && parseDouble(weight) < 60;
            if(!isValid){
                    System.out.println("O peso não é permitido ser maior que 60 e menor que 0.5 ");
                    return isValidWeight(scanner);
                }
        }
            catch (Exception e) {
                System.out.println("Error  : " + e.getMessage());
            }
        return weight;
    }
    public String isValidBreed(Scanner scanner){
        String breed = scanner.nextLine();
        if(breed.isEmpty()){
            return null;
        }
        try{
            boolean isValid = breed.matches("[a-zA-Z ]+");
            if(!isValid){
                System.out.println("Apenas letras, por favor.");
                return isValidBreed(scanner);
            }

        }catch (IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
        }
        return breed;
    }
}











