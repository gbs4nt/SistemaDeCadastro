package model;

    public class Pet {
        private String petName;
        private String petAdressHouseNumber;
        private PetType petType;
        private PetGender petGender;
        private int petAge;
        private int petWeight;
        private String petBreed;
        public static final String NAO_INFORMADO = "Não Informado";

        public String setPetName(String petName) {
            if(petName== null || petName.trim().isEmpty()) {
                this.petName = NAO_INFORMADO;
            return this.petName;
            }
            if(!petName.contains(" ")|| !petName.matches("[a-zA-ZÀ-ÿ ]+"))
            {
                throw new IllegalArgumentException("O pet deve ter um nome e sobrenome");
            }
            this.petName = petName.trim();

            return this.petName;
        }
        public void setPetType(PetType petType) {
            this.petType = petType;
        }
        public void setPetTypeChoose(int escolha) {
            if (escolha==1){
                setPetType(PetType.CACHORRO);

            }if(escolha==2){
                setPetType(PetType.GATO);
            }
        }
        public void setPetGenderChoose(int escolha){
            if(escolha==1){
                setPetGender(PetGender.MACHO);
            } if(escolha==2){
                setPetGender(PetGender.FEMEA);
            }

        }
        public void setAdressHouseNumber(String petAdressHouseNumber){

            this.petAdressHouseNumber=petAdressHouseNumber;

        }
        public String getPetName(){
            return petName;
        }





        public void setPetGender(PetGender petGender) {
            this.petGender = petGender;
        }

        public void setPetAge(int petAge) {
            this.petAge = petAge;
        }

        public void setPetWeight(int petWeight) {
            this.petWeight = petWeight;
        }

        public void setPetBreed(String petBreed) {
            this.petBreed = petBreed;
        }
    }
