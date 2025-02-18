class LmnhUdon extends LmnhNoodle {
    LmnhUdon() {
        super(2.56, 0.34, "spiral", "bleach");
    }

    @Override
    public String toString(){
        return "Udon:: " + lengthInCentimeters + widthInCentimeters + shape + ingredients;
    }

    @Override
    public String getCookingPrep(){
        return "stick the udon in the pan and do one";
    }


}
