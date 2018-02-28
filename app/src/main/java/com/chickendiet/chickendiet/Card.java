package com.chickendiet.chickendiet;

/**
 * Created by Tolulope Ogunjuyigbe on 10/23/2017.
 */

public class Card {
    private String imgURL;
    private String ingredientname, energy, crudeprotein, crudefibre, lysine, methionine, calcium, phosphorus, fats;


    public Card(String imgURL, String ingredientname, String energy, String crudeprotein, String crudefibre,
                String lysine, String methionine, String calcium, String phosphorus, String fats) {
        this.imgURL = imgURL;
        this.ingredientname = ingredientname;
        this.energy = energy;
        this.crudeprotein = crudeprotein;
        this.crudefibre = crudefibre;
        this.lysine = lysine;
        this.methionine = methionine;
        this.calcium = calcium;
        this.fats = fats;
        this.phosphorus = phosphorus;

    }

    public String getImgURL(){
        return imgURL;
    }

    public void  setImgURL(String imgURL){
        this.imgURL = imgURL;
    }

    public String getIngredientname(){
        return ingredientname;
    }

    public void  setIngredientname(String ingredientname){
        this.ingredientname = ingredientname;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getCrudeprotein() {
        return crudeprotein;
    }

    public void setCrudeprotein(String crudeprotein) {
        this.crudeprotein = crudeprotein;
    }

    public String getCrudefibre() {
        return crudefibre;
    }

    public void setCrudefibre(String crudefibre) {
        this.crudefibre = crudefibre;
    }

    public String getLysine() {
        return lysine;
    }

    public void setlysine(String lysine) {
        this.lysine = lysine;
    }

    public String getMethionine() {
        return methionine;
    }

    public void setMethionine(String methionine) {
        this.methionine = methionine;
    }

    public String getCalcium() {
        return calcium;
    }

    public void setCalcium(String calcium) {
        this.calcium = calcium;
    }

    public String getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(String phosphorus) {
        this.phosphorus = phosphorus;
    }

    public String getFats() {
        return fats;
    }

    public void setFats(String fats) {
        this.fats = fats;
    }
}
