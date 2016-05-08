package momo.fjnu.edu.cn.demotest.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import momo.fjnu.edu.cn.demotest.fragment.AppGameFragment;
import momo.fjnu.edu.cn.demotest.fragment.EnterTainFragment;

/**
 * 切换Fragmen的适配器
 * Created by GaoFei on 2016/5/8.
 */
public class TabAdapter extends FragmentPagerAdapter{

    private Class<?>[] contentFragments = new Class[]{AppGameFragment.class, EnterTainFragment.class};
    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment) contentFragments[position].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int getCount() {
        return contentFragments.length;
    }
}
