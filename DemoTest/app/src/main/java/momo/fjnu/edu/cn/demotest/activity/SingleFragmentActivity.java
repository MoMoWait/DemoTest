package momo.fjnu.edu.cn.demotest.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import momo.fjnu.edu.cn.demotest.R;


/**
 * 单个Fragment的Activity
 * Created by GaoFei on 2016/3/8.
 */
public abstract class SingleFragmentActivity extends AppBaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, createFragment()).commit();
    }

    public abstract Fragment createFragment();
}
