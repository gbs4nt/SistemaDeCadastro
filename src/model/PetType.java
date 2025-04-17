package model;

public enum PetType {
    DOG("Cachorro"), CAT("Gato");
    private final String tipo;
    PetType(String tipo){
        this.tipo = tipo;
    }
}
