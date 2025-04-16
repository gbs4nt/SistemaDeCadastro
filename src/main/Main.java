package main;

import model.Pet;
import repository.FileRepository;
import services.CadastrarPet;
import services.PrintarMenu;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        PrintarMenu print = new PrintarMenu();
        FileRepository arquivo = new FileRepository();
        int option = print.printarMenu();
        CadastrarPet cadastro = new CadastrarPet();
        Pet pet = new Pet();


        do{
            if(option ==1){
                cadastro.cadastrarPet();
              
                break;

            }
        }while(option!=6);





//       Pattern pattern = Pattern.compile("^[0-9]+$");


    }


}