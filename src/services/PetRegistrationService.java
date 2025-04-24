package services;


import model.*;
import repository.FileRepository;
import utils.ValidatorUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class PetRegistrationService {

    ValidatorUtils validatorUtils = new ValidatorUtils();
    Pet pet = new Pet();

    public void registerPet() {

        Scanner input = new Scanner(System.in);


        FileRepository.readSpecifyLine(1);
        String validName = validatorUtils.isValidName(input);
        pet.setPetName(validName);


        FileRepository.readSpecifyLine(2);
        int validType = validatorUtils.isValidType(input);

        switch (validType) {
            case 1 -> {
                pet.setPetType(PetType.DOG);
            }
            case 2 -> {
                pet.setPetType(PetType.CAT);
            }
            default -> {
                System.out.println("Invalid.");
            }
        }



        FileRepository.readSpecifyLine(3);
        int validGender = validatorUtils.isValidGender(input);
        switch (validGender) {
            case 0 ->{
                pet.setPetGender(null);
            }
            case 1 -> {
                pet.setPetGender(PetGender.MALE);
            }
            case 2 -> {
                pet.setPetGender(PetGender.FEMALE);
            }

            default -> {
                System.out.println("Invalid \n\n");
            }
        }




        FileRepository.readSpecifyLine(4);
        FileRepository.readSpecifyLine(5);
        String validNumber = validatorUtils.isValidHouseNumber(input);
        pet.setAdressHouseNumber(validNumber);


        FileRepository.readSpecifyLine(6);
        String validCity = validatorUtils.isValidCity(input);
        pet.setpetAdressCity(validCity);


        FileRepository.readSpecifyLine(7);
        String validStreet = validatorUtils.isValidStreet(input);
        pet.setPetAdressStreet(validStreet);


        FileRepository.readSpecifyLine(8);
        double validAge = validatorUtils.isValidAge(input);
        pet.setPetAge(validAge);


        FileRepository.readSpecifyLine(9);
        String validWeight = validatorUtils.isValidWeight(input);
        pet.setPetWeight(validWeight);


        FileRepository.readSpecifyLine(10);
        String validBreed = validatorUtils.isValidBreed(input);
        pet.setPetBreed(validBreed);

    petSave();
    }
       public void petSave(){
        String path = "C:\\Users\\Gabriel\\Documents\\Estudos\\DesafioCadastro\\desafioCadastro\\src\\registredPets";
        File dir = new File(path);
        if(!dir.exists()) {
            dir.mkdirs();
        }

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
            String timestamp = now.format(formatter);
            String fileName =  timestamp+"-" + pet.getPetName().toUpperCase().replace(" ", "") + ".txt";


        File file = new File(path+ "\\"+fileName);
        PetType tipoCachorro = PetType.DOG;
        PetType tipoGato = PetType.CAT;
        PetGender macho = PetGender.MALE;
        PetGender femea = PetGender.FEMALE;
        try(
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw); ) {
            file.createNewFile();
//            if(pet.getPetAge()!=null && !pet.getPetAge().isEmpty()) {
                boolean isLessThan1 =pet.getPetAge()< 1;

            if(pet.getPetName()!=null) {
                bw.write("Nome: "+pet.getPetName());
                bw.newLine();
                bw.flush();
            }else{
                bw.write("Não informado");
                bw.newLine();
                bw.flush();
            }
            if(pet.getPetType()== PetType.DOG) {
                bw.write("Tipo: "+tipoCachorro.getTypeName());
                bw.newLine();
                bw.flush();
            }else if(pet.getPetType() == PetType.CAT){
                bw.write("Tipo: "+tipoGato.getTypeName());
                bw.newLine();
                bw.flush();
            }
            else{
                bw.write("Não informado");
                bw.newLine();
                bw.flush();
            }
            if(pet.getPetGender()== PetGender.FEMALE) {
                bw.write("Gênero: "+femea.getGenderName());
                bw.newLine();
                bw.flush();
            }else if(pet.getPetGender()== PetGender.MALE){
                bw.write("Gênero: "+macho.getGenderName());
                bw.newLine();
                bw.flush();

            }else{
                bw.write("Gênero: Não informado");
                bw.newLine();
                bw.flush();
            }
            if(pet.getPetAdressHouseNumber()!=null &&pet.getPetAdressCity()!= null &&pet.getPetAdressStreet() !=null) {
            bw.write("Endereço: "+pet.getPetAdressStreet()+", "+pet.getPetAdressHouseNumber()+", "+pet.getPetAdressCity());
            bw.newLine();
            bw.flush();
            } else {
                bw.write("Endereço: Não informado");
                bw.newLine();
                bw.flush();
            }
            if(pet.getPetAge()!=0) {
                bw.write("Idade: "+pet.getPetAge()+" anos");
                bw.newLine();
                bw.flush();
            }else if(pet.getPetAge()<1){
                bw.write(pet.getPetWeight()+" meses \n");
            }else{
                bw.write("Não informado");
                bw.newLine();
                bw.flush();
            }
            if(pet.getPetWeight() !=null ) {
                bw.write("Peso: "+pet.getPetWeight()+"Kg");
                bw.newLine();
                bw.flush();
            }else if (pet.getPetWeight()==null){
                bw.write("Não informado");
                bw.newLine();
                bw.flush();
            }
            if(pet.getPetBreed() !=null) {
                bw.write("Raça: "+pet.getPetBreed());
                bw.newLine();
                bw.flush();

            }else{
                bw.write("Não informado");
                bw.newLine();
                bw.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }
}