package momo.fjnu.edu.cn.demotest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;

import java.util.List;

import momo.cn.edu.fjnu.androidutils.utils.SizeUtils;
import momo.fjnu.edu.cn.demotest.R;
import momo.fjnu.edu.cn.demotest.pojo.AppGameInfo;

/**
 * 应用有些列表适配器
 * Created by GaoFei on 2016/5/9.
 */
public class AppGameAdapter extends RecyclerView.Adapter<AppGameAdapter.AppGameHolder>{

    private List<AppGameInfo> mAppGameInfos;
    public AppGameAdapter(List<AppGameInfo> infos){
        mAppGameInfos = infos;
    }

    @Override
    public AppGameHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_app_game_item, parent, false);
        return new AppGameHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AppGameHolder holder, int position) {
        AppGameInfo appGameInfo = mAppGameInfos.get(position);
        AQuery aQuery = new AQuery(holder.imgAppGame);
        aQuery.image(appGameInfo.getIconUrl(), true, true, SizeUtils.dp2px(holder.imgAppGame.getContext(), 100), 0);
        holder.textAppTitle.setText(appGameInfo.getTitle());
    }

    @Override
    public int getItemCount() {
        return mAppGameInfos.size();
    }

    public AppGameInfo getAppGameInfo(int position){
        return mAppGameInfos.get(position);
    }

    public class AppGameHolder extends RecyclerView.ViewHolder {
        ImageView imgAppGame;
        TextView textAppTitle;
        public AppGameHolder(View view) {
            super(view);
            imgAppGame = (ImageView) view.findViewById(R.id.img_app_game);
            textAppTitle = (TextView) view.findViewById(R.id.text_app_title);
        }
    }

}
