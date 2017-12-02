package com.vteam.foodfriends.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by phuongbka on 12/2/17.
 */

public class Image {
    @SerializedName("data")
    @Expose
    private List<Data> data;
    public Image(){};

    public Image(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Image{" +
                "data=" + data +
                '}';
    }
}
