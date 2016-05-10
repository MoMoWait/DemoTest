package momo.fjnu.edu.cn.demotest.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import momo.cn.edu.fjnu.androidutils.base.BaseFragment;
import momo.fjnu.edu.cn.demotest.R;
import momo.fjnu.edu.cn.demotest.activity.AppGameInfoActivity;
import momo.fjnu.edu.cn.demotest.adapter.AppGameAdapter;
import momo.fjnu.edu.cn.demotest.data.AppGameInfos;
import momo.fjnu.edu.cn.demotest.pojo.AppGameInfo;

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

    private AppGameAdapter mSelectAppGameAdapter;

    private AppGameAdapter mSocialAppGameAdapter;

    /**点击列表某一项的监听事件*/
    public interface AppGameItemClickListener{
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);
}

    @Override
    public void initView() {
        List<AppGameInfo> appGameInfos = new ArrayList<>();
        Random random = new Random();
        for(String iconUrl : AppGameInfos.icons){
            AppGameInfo appGameInfo = new AppGameInfo();
            appGameInfo.setIconUrl(iconUrl);
            appGameInfo.setTitle(AppGameInfos.titles[random.nextInt(AppGameInfos.titles.length)]);
            appGameInfo.setSubTitle(AppGameInfos.subTitles[random.nextInt(AppGameInfos.subTitles.length)]);
            appGameInfos.add(appGameInfo);
        }
        LinearLayoutManager selectLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyleSelect.setLayoutManager(selectLayoutManager);
        mSelectAppGameAdapter = new AppGameAdapter(appGameInfos);
        mRecyleSelect.setAdapter(mSelectAppGameAdapter);

        LinearLayoutManager socialLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyleSocial.setLayoutManager(socialLayoutManager);
        mSocialAppGameAdapter = new AppGameAdapter(appGameInfos);
        mRecyleSocial.setAdapter(mSocialAppGameAdapter);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {
        mRecyleSelect.addOnItemTouchListener(new RecylerTouchListener(getContext(), mRecyleSelect, new AppGameItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), AppGameInfoActivity.class);
                intent.putExtra("appGameInfo", mSelectAppGameAdapter.getAppGameInfo(position));
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        mRecyleSocial.addOnItemTouchListener(new RecylerTouchListener(getContext(), mRecyleSocial, new AppGameItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), AppGameInfoActivity.class);
                intent.putExtra("appGameInfo", mSocialAppGameAdapter.getAppGameInfo(position));
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    public class RecylerTouchListener implements RecyclerView.OnItemTouchListener{

        private GestureDetector gestureDetector;
        private AppGameFragment.AppGameItemClickListener mItemClickListener;

        public RecylerTouchListener(Context context, final RecyclerView recyclerView, AppGameFragment.AppGameItemClickListener itemClickListener){
            mItemClickListener = itemClickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && mItemClickListener != null) {
                        mItemClickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && mItemClickListener != null && gestureDetector.onTouchEvent(e)) {
                mItemClickListener.onClick(child, rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
