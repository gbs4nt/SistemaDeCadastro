package model;

    public class Pet {
        private String petName;
        private String petAdressHouseNumber;
        private String petAdressCity;
        private String petAdressStreet;
        private PetType petType;
        private PetGender petGender;
        private String petAge;
        private String petWeight;
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
                setPetType(PetType.DOG);

            }if(escolha==2){
                setPetType(PetType.CAT);
            }
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
            this.petAdressCity = petAdressCity;
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

        public void setPetAge(String petAge) {
            if (petAge == null){
                this.petAge = NAO_INFORMADO;
            }
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
    }
