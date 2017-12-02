package com.vteam.foodfriends.data.remote.api;

import com.vteam.foodfriends.data.model.Data;
import com.vteam.foodfriends.data.model.Image;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by phuongbka on 12/3/17.
 */

public interface GetAllImage {
    @GET("https://www.foody.vn/__get/Gallery/ListRestaurantPicturesWithPaging?pageIndex=1&pageSize=20&restaurantId=663781")
    Call<Image> getAllImage();
}
