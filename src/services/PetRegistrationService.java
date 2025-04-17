package services;


import model.Pet;
import repository.FileRepository;
import utils.ValidatorUtils;

import java.io.File;
import java.util.Scanner;

public class PetRegistrationService {


    public void registerPet() {
        Pet pet = new Pet();
        ValidatorUtils validatorUtils = new ValidatorUtils();
        Scanner input = new Scanner(System.in);

        FileRepository.readSpecifyLine(1);
        String nomeValido = validatorUtils.isValidName(input);
        pet.setPetName(nomeValido);



        FileRepository.readSpecifyLine(2);
        int tipoValido = validatorUtils.isValidType(input);
        pet.setPetTypeChoose(tipoValido);
        input.nextLine();


        FileRepository.readSpecifyLine(3);
        int generoValido = validatorUtils.isValidGender(input);
        pet.setPetGenderChoose(generoValido);
        input.nextLine();

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
        String validAge = validatorUtils.isValidAge(input);
        pet.setPetAge(validAge);
        FileRepository.readSpecifyLine(9);
        String validWeight = validatorUtils.isValidWeight(input);
        pet.setPetWeight(validWeight);
        FileRepository.readSpecifyLine(10);
        String validBreed = validatorUtils.isValidBreed(input);
        pet.setPetBreed(validBreed);



    }
}