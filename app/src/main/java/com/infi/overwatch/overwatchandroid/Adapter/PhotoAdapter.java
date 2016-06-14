package com.infi.overwatch.overwatchandroid.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.infi.overwatch.overwatchandroid.Activity.HeroDetailActivity;
import com.infi.overwatch.overwatchandroid.R;
import com.infi.overwatch.overwatchandroid.model.heros.Heros;

import java.util.ArrayList;

/**
 * Created by TQi on 5/18/16.
 */
public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    private ArrayList<Heros> heros = new ArrayList<>();
    private Context context;
    private Activity fromActivity;

    public PhotoAdapter(ArrayList<Heros> heros, Context context, Activity fromActivity){
        this.heros = heros;
        this.context = context;
        this.fromActivity = fromActivity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout heroHolder;
        public LinearLayout heroNameHolder;
        public ImageView imageView;
        public TextView heroName;
        public ViewHolder(View view){
            super(view);
            heroHolder = (LinearLayout) view.findViewById(R.id.mainHolder);
            heroNameHolder = (LinearLayout) view.findViewById(R.id.heroNameHolder);
            imageView = (ImageView) view.findViewById(R.id.heroPoster);
            heroName = (TextView) view.findViewById(R.id.heroName);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hero_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.heroName.setText(heros.get(position).getHeroname());
        try {
            holder.imageView.setImageDrawable(context.getResources().getDrawable(context.getResources().getIdentifier(heros.get(position).getImgPath().toLowerCase().replace(".png",""), "drawable", context.getPackageName())));
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HeroDetailActivity.launchActivity(fromActivity, heros.get(position).getHeroname());
                }
            });
        }catch (Resources.NotFoundException e){
            Log.e("NOT FOUND", "can't find"+heros.get(position).getImgPath().toLowerCase().replace(".png",""));
        }


    }

    @Override
    public int getItemCount() {
        return heros.size();
    }
}
