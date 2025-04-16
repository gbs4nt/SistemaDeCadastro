package services;


import model.Pet;
import model.PetGender;
import repository.FileRepository;
import utils.ValidatorUtils;

import java.util.Scanner;

public class CadastrarPet {


    public void cadastrarPet() {
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
        String numeroValido = validatorUtils.isValidHouseNumber(input);
        pet.setAdressHouseNumber(numeroValido);




    }
}