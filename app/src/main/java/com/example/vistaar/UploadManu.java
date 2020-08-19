package com.example.vistaar;

public class UploadManu {
    private String mName;
    private String mInfo;
    private String mPrice;
    private String mImageUrl;


    public UploadManu() {
        //empty constructor needed
    }
    UploadManu(String name, String info,  String price,String imageUrl) {
        mName = name;
        mInfo = info;
        mImageUrl = imageUrl;
        mPrice = price;


    }
    public String getName() {
        return mName;
    }
    public void setName(String name) {
        mName = name;
    }
    String getImageUrl() {
        return mImageUrl;
    }
    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    String getmInfo() {
        return mInfo;
    }
    public void setmInfo(String info) {
        mInfo = info;
    }
    public String getPrice() {
        return mPrice;
    }
    public void setPrice(String price) {
        mPrice = price;
    }

}
