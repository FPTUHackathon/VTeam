package com.vteam.foodfriends.ui.home;

import com.vteam.foodfriends.data.model.Restaurant;
import com.vteam.foodfriends.ui.base.BasePresenter;
import com.vteam.foodfriends.ui.base.BaseView;

import java.util.List;

/**
 * Created by H2PhySicS on 11/28/2017.
 */

public class HomeContract {
    public interface Presenter extends BasePresenter{
        void fetchRestaurants();
    }

    public interface View extends BaseView<Presenter>{
        void showRestaurants(List<Restaurant> list);

    }
}
