package model;

public enum PetGender {
    MALE("Macho"), FEMALE("Femea");

    private final String genero;
     PetGender(String genero){
        this.genero = genero;
    }
    public String getGenderName(){
        return genero;
    }
}
