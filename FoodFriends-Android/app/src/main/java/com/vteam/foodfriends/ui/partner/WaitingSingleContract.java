package com.vteam.foodfriends.ui.partner;

import com.vteam.foodfriends.data.model.Pair;
import com.vteam.foodfriends.ui.base.BasePresenter;
import com.vteam.foodfriends.ui.base.BaseView;

import java.util.List;
import java.util.Map;

/**
 * Created by yukinohara on 12/2/17.
 */

public class WaitingSingleContract {
    public interface Presenter extends BasePresenter{
        void createPair(String resId, List<Map<String, Object>> list, String time);
        void getPairs(String resId);

    }

    public interface View extends BaseView<Presenter>{
        void showPairs(List<Map<String, Object>> pairsFirebase, List<Pair> pairs);
    }
}
