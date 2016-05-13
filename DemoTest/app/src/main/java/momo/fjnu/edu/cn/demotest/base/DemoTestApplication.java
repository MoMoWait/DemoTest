package momo.fjnu.edu.cn.demotest.base;

import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.BitmapAjaxCallback;

import org.xutils.x;

import momo.cn.edu.fjnu.androidutils.base.BaseApplication;

/**
 * APP实例
 * Created by GaoFei on 2016/5/8.
 */
public class DemoTestApplication extends BaseApplication{

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        initAquery();
    }



    /**
     * 初始化Aquery框架
     */
    public void initAquery(){
        //设置网络最大连接数
        AjaxCallback.setNetworkLimit(8);
        //设置缓存图标(<50px)的最大数量
        BitmapAjaxCallback.setIconCacheLimit(20);
        //设置可以在内存中缓存的最大图片数量
        BitmapAjaxCallback.setCacheLimit(50);
        //设置可以缓存的最大图片尺寸
        BitmapAjaxCallback.setPixelLimit(512 * 512);
        //设置图片最大缓存像素
        BitmapAjaxCallback.setMaxPixelLimit(2621440);
    }
}
