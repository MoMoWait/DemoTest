package momo.fjnu.edu.cn.demotest.activity;

import android.support.v4.app.Fragment;

import momo.fjnu.edu.cn.demotest.fragment.MainFragment;

/**
 * 主页面,包含AppGame部分和Entertainment部分
 */
public class MainActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new MainFragment();
    }
}
