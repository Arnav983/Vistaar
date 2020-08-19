package com.example.vistaar;

public class Upload {
    private String mName;
    private String mImageUrl;
    private String mColor;
    private String mPrice;
    private String mApp;
    private String mPattern;
    private String mSize;

    public Upload() {
        //empty constructor needed
    }
    Upload(String name, String imageUrl, String color, String price,String app,String pattern,String size) {
        mName = name;
        mImageUrl = imageUrl;
        mColor = color;
        mPrice = price;
        mApp = app;
        mPattern = pattern;
        mSize = size;

    }
    public String getName() {
        return mName;
    }
    public void setName(String name) {
        mName = name;
    }
    public String getColor() {
        return mColor;
    }
    public void setColor(String color) {

        mColor = color;
    }

    String getImageUrl() {
        return mImageUrl;
    }
    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
    public String getPrice() {
        return mPrice;
    }
    public void setPrice(String price) {
        mPrice = price;
    }
    public String getmPattern() {
        return mPattern;
    }
    public void setmPattern(String pattern) {
        mPattern = pattern;
    }
    public String getmApp() {
        return mApp;
    }
    public void setmApp(String app) {
        mApp = app;
    }
    public String getmSize() {
        return mSize;
    }
    public void setmSize(String size) {
        mSize = size;
    }
}
