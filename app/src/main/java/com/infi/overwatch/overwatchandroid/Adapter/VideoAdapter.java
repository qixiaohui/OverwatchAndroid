package com.infi.overwatch.overwatchandroid.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.infi.overwatch.overwatchandroid.Activity.YoutubeActivity;
import com.infi.overwatch.overwatchandroid.R;
import com.infi.overwatch.overwatchandroid.model.video.Videos;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by TQi on 5/18/16.
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private ArrayList<Videos> videos = new ArrayList<>();
    private Context context;
    private Activity fromActivity;

    public VideoAdapter(ArrayList<Videos> videos, Activity activity, Context context){
        this.videos = videos;
        this.context = context;
        fromActivity = activity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView screenShot;
        public TextView title;
        public TextView player;
        public RelativeLayout infoCard;
        public ViewHolder(View view){
            super(view);
            screenShot = (ImageView) view.findViewById(R.id.screenshot);
            title = (TextView) view.findViewById(R.id.title);
            player = (TextView) view.findViewById(R.id.player);
            infoCard = (RelativeLayout) view.findViewById(R.id.infocard);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Picasso.with(context).load("http://img.youtube.com/vi/"+videos.get(position).getVideoId()+"/mqdefault.jpg").into(holder.screenShot);
        holder.title.setText(videos.get(position).getTitle());
        holder.infoCard.setVisibility(View.GONE);
        holder.screenShot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoutubeActivity.launchActivity(fromActivity, videos.get(position).getUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public ArrayList<Videos> getVideos(){
        return videos;
    }

    public void addMoreVideos(ArrayList<Videos> videos, int index){
        if(index*12 >= this.videos.size()){
            this.videos.addAll(videos);
        }
    }
}
