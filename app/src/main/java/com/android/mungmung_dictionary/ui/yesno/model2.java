package com.android.mungmung_dictionary.ui.yesno;

public class model2 {
    String foodname, function, foodimage;

    public model2() {
    }

    public model2(String foodname , String function, String foodimage) {
        this.foodname = foodname;
        this.function = function;
        this.foodimage = foodimage;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getFoodimage() {
        return foodimage;
    }

    public void setFoodimage(String foodimage) {
        this.foodimage = foodimage;
    }
}