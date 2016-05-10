package momo.fjnu.edu.cn.demotest.fragment;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import momo.cn.edu.fjnu.androidutils.base.BaseFragment;
import momo.cn.edu.fjnu.androidutils.utils.ResourceUtils;
import momo.cn.edu.fjnu.androidutils.utils.SizeUtils;
import momo.fjnu.edu.cn.demotest.R;
import momo.fjnu.edu.cn.demotest.pojo.AppGameInfo;

/**
 * 应用游戏详情页面
 * Created by GaoFei on 2016/5/10.
 */
@ContentView(R.layout.fragment_app_game_info)
public class AppGameInfoFragment extends BaseFragment{

    private ActionBar mAppGameInfoActionBar;

    @ViewInject(R.id.img_app_game)
    private ImageView mImgAppGame;

    @ViewInject(R.id.text_app_game_title)
    private TextView mTextAppGameTitle;

    @ViewInject(R.id.text_app_game_subTitle)
    private TextView mTextAppGameSubTitle;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void initView() {
        mAppGameInfoActionBar = getActivity().getActionBar();
        if(null != mAppGameInfoActionBar){
            mAppGameInfoActionBar.setDisplayShowCustomEnabled(true);
            //设置自定义的ActionBar
            mAppGameInfoActionBar.setCustomView(R.layout.actionbar_app_game_info);
            //设置StatusBar颜色
            getActivity().getWindow().setStatusBarColor(ResourceUtils.getColor(R.color.statusbar_gray));
        }

        AppGameInfo appGameInfo = (AppGameInfo) getActivity().getIntent().getSerializableExtra("appGameInfo");
        AQuery aQuery = new AQuery(mImgAppGame);
        aQuery.image(appGameInfo.getIconUrl(), true, true, SizeUtils.dp2px(getContext(), 100), 0);
        mTextAppGameTitle.setText(appGameInfo.getTitle());
        mTextAppGameSubTitle.setText(appGameInfo.getSubTitle());
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }
}
