package momo.fjnu.edu.cn.demotest.pojo;

import java.io.Serializable;

/**
 * 应用游戏信息
 * Created by GaoFei on 2016/5/9.
 */
public class AppGameInfo implements Serializable{
    /**标题*/
    private String title;
    /**子标题*/
    private String subTitle;
    /**Icon URL*/
    private String iconUrl;

    public AppGameInfo(){

    }

    public AppGameInfo(String title, String subTitle, String iconUrl) {
        this.title = title;
        this.subTitle = subTitle;
        this.iconUrl = iconUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

}
