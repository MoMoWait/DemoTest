package momo.fjnu.edu.cn.demotest.activity;

import android.support.v4.app.Fragment;

import momo.fjnu.edu.cn.demotest.fragment.AppGameInfoFragment;

/**
 * 应用游戏详情页面
 * Created by GaoFei on 2016/5/10.
 */
public class AppGameInfoActivity extends BaseGameInfoActivity{



    @Override
    public Fragment createFragment() {
        return new AppGameInfoFragment();
    }
}
