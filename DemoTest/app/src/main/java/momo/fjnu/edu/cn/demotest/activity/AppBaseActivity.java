package momo.fjnu.edu.cn.demotest.activity;

import android.os.Bundle;
import android.view.KeyEvent;

import momo.cn.edu.fjnu.androidutils.base.BaseActivity;
import momo.fjnu.edu.cn.demotest.R;

/**
 * APP基本Activity类
 * Created by GaoFei on 2016/5/8.
 */
public class AppBaseActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK ){
            finish();
            overridePendingTransition(R.anim.activity_exit_left, R.anim.activity_exit_right);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
