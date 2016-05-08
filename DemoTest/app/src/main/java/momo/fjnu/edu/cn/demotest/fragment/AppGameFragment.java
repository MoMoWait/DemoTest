package momo.fjnu.edu.cn.demotest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

import momo.cn.edu.fjnu.androidutils.base.BaseFragment;
import momo.fjnu.edu.cn.demotest.R;

/**
 * 应用有些页面
 * Created by GaoFei on 2016/5/8.
 */
@ContentView(R.layout.fragment_app_game)
public class AppGameFragment extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);
}

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }
}
