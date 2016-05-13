package momo.fjnu.edu.cn.demotest.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

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
    @ViewInject(R.id.recyle_communication)
    private RecyclerView mRecyleCommunication;
    @ViewInject(R.id.recyle_photography)
    private RecyclerView mRecylePhotoGraphy;
    @ViewInject(R.id.scroll_app_game)
    private ScrollView mScrollAppGame;
    private AppGameAdapter mSelectAppGameAdapter;
    private AppGameAdapter mSocialAppGameAdapter;
    private AppGameAdapter mCommunicationAppGameAdapter;
    private AppGameAdapter mPhotoGraphyAppGameAdapter;
    private ActionBar mMainActionBar;
    /**操作栏的高度*/
    private int mActionBarHeight;
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
        mMainActionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if(null != mMainActionBar)
            mMainActionBar.setShowHideAnimationEnabled(true);

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
        mSelectAppGameAdapter = new AppGameAdapter(appGameInfos.subList(0, 10));
        mRecyleSelect.setAdapter(mSelectAppGameAdapter);

        LinearLayoutManager socialLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyleSocial.setLayoutManager(socialLayoutManager);
        mSocialAppGameAdapter = new AppGameAdapter(appGameInfos.subList(10, 20));
        mRecyleSocial.setAdapter(mSocialAppGameAdapter);

        LinearLayoutManager communicationLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyleCommunication.setLayoutManager(communicationLayoutManager);
        mCommunicationAppGameAdapter = new AppGameAdapter(appGameInfos.subList(20, 30));
        mRecyleCommunication.setAdapter(mCommunicationAppGameAdapter);

        LinearLayoutManager photographyLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecylePhotoGraphy.setLayoutManager(photographyLayoutManager);
        mPhotoGraphyAppGameAdapter = new AppGameAdapter(appGameInfos.subList(30, 40));
        mRecylePhotoGraphy.setAdapter(mPhotoGraphyAppGameAdapter);
    }

    @Override
    public void initData() {
        TypedValue tv = new TypedValue();
        if (getActivity().getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            mActionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
        }
    }


    @Override
    public void initEvent() {
        mRecyleSelect.addOnItemTouchListener(new RecylerTouchListener(getContext(), mRecyleSelect, new AppGameItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), AppGameInfoActivity.class);
                intent.putExtra("appGameInfo", mSelectAppGameAdapter.getAppGameInfo(position));
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(getActivity(), view.findViewById(R.id.img_app_game), "move");
                //Shared Element Transition
                startActivity(intent, options.toBundle());
                getActivity().overridePendingTransition(R.anim.activity_enter_right, R.anim.activity_enter_left);
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
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(getActivity(), view.findViewById(R.id.img_app_game), "move");
                //Shared Element Transition
                startActivity(intent, options.toBundle());
                getActivity().overridePendingTransition(R.anim.activity_enter_right, R.anim.activity_enter_left);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        mRecyleCommunication.addOnItemTouchListener(new RecylerTouchListener(getContext(), mRecyleCommunication, new AppGameItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), AppGameInfoActivity.class);
                intent.putExtra("appGameInfo", mCommunicationAppGameAdapter.getAppGameInfo(position));
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(getActivity(), view.findViewById(R.id.img_app_game), "move");
                //Shared Element Transition
                startActivity(intent, options.toBundle());
                getActivity().overridePendingTransition(R.anim.activity_enter_right, R.anim.activity_enter_left);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        mRecylePhotoGraphy.addOnItemTouchListener(new RecylerTouchListener(getContext(), mRecylePhotoGraphy, new AppGameItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), AppGameInfoActivity.class);
                intent.putExtra("appGameInfo", mPhotoGraphyAppGameAdapter.getAppGameInfo(position));
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(getActivity(), view.findViewById(R.id.img_app_game), "move");
                //Shared Element Transition
                startActivity(intent, options.toBundle());
                getActivity().overridePendingTransition(R.anim.activity_enter_right, R.anim.activity_enter_left);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        //滑动监听事件
        mScrollAppGame.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
               // Log.i(TAG, "ScrollHeight = " + mScrollAppGame.getScrollY());
                if(null != mMainActionBar){
                    if(mMainActionBar.isShowing() && mScrollAppGame.getScrollY() > mActionBarHeight)
                        mMainActionBar.hide();
                    else if(!mMainActionBar.isShowing() && mScrollAppGame.getScrollY() < mActionBarHeight)
                        mMainActionBar.show();
                }
            }
        });

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
