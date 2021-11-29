package com.android.mungmung_dictionary.ui.feed;

public class model {
    String brand,material,name,ingredients,profile;

    public model() {
    }

    public model(String brand , String material , String name , String ingredients, String profile) {
        this.brand = brand;
        this.material = material;
        this.name = name;
        this.ingredients = ingredients;
        this.profile = profile;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
