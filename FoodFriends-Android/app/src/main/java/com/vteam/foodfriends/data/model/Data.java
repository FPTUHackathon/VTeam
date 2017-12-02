package com.vteam.foodfriends.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by phuongbka on 12/2/17.
 */

public class Data implements Serializable{
    @SerializedName("FullSizeImageUrl")
    @Expose
    private String imageUrl;

    public Data(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Data{" +
                "imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
