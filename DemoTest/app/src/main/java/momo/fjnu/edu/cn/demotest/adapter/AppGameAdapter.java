package momo.fjnu.edu.cn.demotest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import momo.fjnu.edu.cn.demotest.R;

/**
 * 应用有些列表适配器
 * Created by GaoFei on 2016/5/9.
 */
public class AppGameAdapter extends RecyclerView.Adapter<AppGameAdapter.AppGameHolder>{

    @Override
    public AppGameHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_app_game_item, parent, false);
        return new AppGameHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AppGameHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class AppGameHolder extends RecyclerView.ViewHolder {

        public AppGameHolder(View view) {
            super(view);
        }
    }

}
