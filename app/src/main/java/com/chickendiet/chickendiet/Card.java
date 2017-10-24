package com.chickendiet.chickendiet;

/**
 * Created by Tolulope Ogunjuyigbe on 10/23/2017.
 */

public class Card {
    private String imgURL;
    private String ingredientname;


    public Card(String imgURL, String ingredientname) {
        this.imgURL = imgURL;
        this.ingredientname = ingredientname;
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
}
