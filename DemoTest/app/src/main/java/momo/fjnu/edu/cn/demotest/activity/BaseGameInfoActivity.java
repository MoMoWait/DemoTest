package momo.fjnu.edu.cn.demotest.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import momo.fjnu.edu.cn.demotest.R;

/**
 * 引用详细信息基类
 * Created by GaoFei on 2016/5/10.
 */
public abstract class BaseGameInfoActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, createFragment()).commit();
    }

    public abstract Fragment createFragment();
}
