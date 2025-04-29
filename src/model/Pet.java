package model;

    public class Pet {
        private String petName;
        private String petAdressHouseNumber;
        private String petAdressCity;
        private String petAdressStreet;
        private PetType petType;
        private int PetTypeChoose;
        private int PetGenderChoose;
        private PetGender petGender;
        private double petAge;
        private String petWeight;
        private String petBreed;
        public static final String NAO_INFORMADO = "Não Informado";
         public Pet(){

        }

        public Pet(String petName, String petAdressHouseNumber, String petAdressCity, String petAdressStreet,  PetType petType, PetGender petGender,  double petAge, String petWeight, String petBreed) {
            this.petName = petName;
            this.petAdressHouseNumber = petAdressHouseNumber;
            this.petAdressCity = petAdressCity;
            this.petAdressStreet = petAdressStreet;
            this.petType = petType;
            this.petGender = petGender;
            this.petAge = petAge;
            this.petWeight = petWeight;
            this.petBreed = petBreed;
        }

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

        public void setPetGenderChoose(int escolha){
            if(escolha==1){
                setPetGender(PetGender.MALE);
            } if(escolha==2){
                setPetGender(PetGender.FEMALE);
            }

        }
        public void setAdressHouseNumber(String petAdressHouseNumber){
             this.petAdressHouseNumber=petAdressHouseNumber;

        }
        public void setpetAdressCity(String petAdressCity){
            if(petAdressCity == null){
                this.petAdressCity = NAO_INFORMADO;
            }
            this.petAdressCity = petAdressCity;
        }

        public String getPetAdressHouseNumber() {
            return petAdressHouseNumber;
        }

        public String getPetAdressCity() {
            return petAdressCity;
        }

        public String getPetAdressStreet() {
            return petAdressStreet;
        }

        public PetType getPetType() {
            return petType;
        }

        public PetGender getPetGender() {
            return petGender;
        }

        public double getPetAge() {
            return petAge;
        }

        public String getPetWeight() {
            return petWeight;
        }

        public String getPetBreed() {
            return petBreed;
        }

        public void setPetAdressStreet(String petAdressStreet){

            this.petAdressStreet = petAdressStreet;
        }

        public String getPetName(){
            return petName;
        }

        public void setPetGender(PetGender petGender) {
            this.petGender = petGender;
        }

        public void setPetAge(double petAge) {
           this.petAge = petAge;
        }

        public void setPetWeight(String petWeight) {
            if(petWeight == null ){
                this.petWeight = NAO_INFORMADO;
            }
            this.petWeight = petWeight;
        }

        public void setPetBreed(String petBreed) {
            this.petBreed = petBreed;
        }

        public PetType getTypeName() {
            return petType;

        }
    }
