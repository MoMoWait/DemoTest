package momo.fjnu.edu.cn.demotest.fragment;


import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import momo.cn.edu.fjnu.androidutils.base.BaseFragment;
import momo.cn.edu.fjnu.androidutils.utils.ResourceUtils;
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

    @ViewInject(R.id.layout_content)
    private LinearLayout mLayoutContent;

    private ActionBar mMainActionBar;
    private TextView[] mContentTabs;
    private int[] mStatusBarColors = {R.color.statusbar_green, R.color.statusbar_gray};
    private int[] mActionBarColors = {R.color.actionbar_green, R.color.actionbar_gray};
    private int[] mActivityThems = {R.style.AppTheme, R.style.AppGrayTheme};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);
    }

    @Override
    public void initView() {
        //获取ActionBar
        mMainActionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if(null != mMainActionBar){
            mMainActionBar.setDisplayShowCustomEnabled(true);
            //设置自定义的ActionBar
            mMainActionBar.setCustomView(R.layout.actionbar_main);
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
               mLayoutContent.setBackground(getResources().getDrawable(mActionBarColors[position], getActivity().getTheme()));
               //改变StatusBar的颜色
               getActivity().getWindow().setStatusBarColor(ResourceUtils.getColor(mStatusBarColors[position]));
               //改变ActionBar背景颜色
               mMainActionBar.setBackgroundDrawable(new ColorDrawable(ResourceUtils.getColor(mActionBarColors[position])));
               for(int i = 0; i != mContentTabs.length; ++i){
                   if(i != position){
                       mContentTabs[i].setCompoundDrawablesWithIntrinsicBounds (0, 0, 0, 0);
                   }else{
                       mContentTabs[i].setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.mipmap.under_line);
                   }

               }
           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });
    }


}
