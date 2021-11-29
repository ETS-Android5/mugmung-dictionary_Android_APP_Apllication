package com.android.mungmung_dictionary.ui.home;

public class model3 {
    String BrandImage;
    String BrandName;

    public model3() {
    }

    public model3(String BrandImage , String BrandName) {
        this.BrandImage = BrandImage;
        this.BrandName = BrandName;
    }

    public String getBrandImage() {
        return BrandImage;
    }

    public void setBrandImage(String brandImage) {
        BrandImage = brandImage;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }
}