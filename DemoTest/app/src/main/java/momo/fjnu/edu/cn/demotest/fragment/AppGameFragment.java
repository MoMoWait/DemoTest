package momo.fjnu.edu.cn.demotest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import momo.cn.edu.fjnu.androidutils.base.BaseFragment;
import momo.fjnu.edu.cn.demotest.R;
import momo.fjnu.edu.cn.demotest.adapter.AppGameAdapter;

/**
 * 应用有些页面
 * Created by GaoFei on 2016/5/8.
 */
@ContentView(R.layout.fragment_app_game)
public class AppGameFragment extends BaseFragment{

    private static final String TAG = "AppGameFragment";

    @ViewInject(R.id.recyle_select)
    private RecyclerView mRecyleSelect;

    @ViewInject(R.id.recyle_social)
    private RecyclerView mRecyleSocial;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);
}

    @Override
    public void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyleSelect.setLayoutManager(layoutManager);
        AppGameAdapter appGameAdapter = new AppGameAdapter();
        mRecyleSelect.setAdapter(appGameAdapter);
       // mRecyleSelect.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }
}
