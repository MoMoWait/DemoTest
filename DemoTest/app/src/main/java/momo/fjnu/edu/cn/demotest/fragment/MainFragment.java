package momo.fjnu.edu.cn.demotest.fragment;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import momo.cn.edu.fjnu.androidutils.base.BaseFragment;
import momo.fjnu.edu.cn.demotest.R;
import momo.fjnu.edu.cn.demotest.adapter.TabAdapter;

/**
 * 主页面（包含列表）
 * Created by GaoFei on 2016/5/8.
 */
@ContentView(R.layout.fragment_main)
public class MainFragment extends BaseFragment{
    private static final String TAG = "MainFragment";

    @ViewInject(R.id.pager_content)
    private ViewPager mPagerContent;

    @ViewInject(R.id.text_app_game)
    private TextView mTextAppGame;

    @ViewInject(R.id.text_enter_tain)
    private TextView mTextEnterTain;

    private TextView[] mContentTabs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);
    }

    @Override
    public void initView() {
        //获取ActionBar
        ActionBar mainActionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if(null != mainActionBar){
            mainActionBar.setDisplayShowCustomEnabled(true);
            //设置自定义的ActionBar
            mainActionBar.setCustomView(R.layout.actionbar_main);
           // mainActionBar.addTab();
        }
        //设置适配器
        mPagerContent.setAdapter(new TabAdapter(getFragmentManager()));

    }

    @Override
    public void initData() {
        mContentTabs = new TextView[]{mTextAppGame, mTextEnterTain};
    }

    @Override
    public void initEvent() {
       mPagerContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @TargetApi(Build.VERSION_CODES.LOLLIPOP)
           @Override
           public void onPageSelected(int position) {
               for(int i = 0; i != mContentTabs.length; ++i){
                   if(i != position)
                       mContentTabs[i].setCompoundDrawablesWithIntrinsicBounds (0, 0, 0, 0);
                   else
                       mContentTabs[i].setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.mipmap.under_line);
               }
           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });
    }


}
