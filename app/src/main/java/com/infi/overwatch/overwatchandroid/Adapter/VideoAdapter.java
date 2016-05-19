package com.infi.overwatch.overwatchandroid.Adapter;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.infi.overwatch.overwatchandroid.Activity.TwitchActivity;
import com.infi.overwatch.overwatchandroid.Activity.WebContentActivity;
import com.infi.overwatch.overwatchandroid.R;
import com.infi.overwatch.overwatchandroid.model.Video.Videos;
import com.squareup.picasso.Picasso;

/**
 * Created by TQi on 5/18/16.
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private Videos videos = new Videos();
    private Context context;
    private Activity fromActivity;

    public VideoAdapter(Videos videos, Activity activity, Context context){
        this.videos = videos;
        this.context = context;
        fromActivity = activity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView screenShot;
        public TextView title;
        public TextView player;
        public ViewHolder(View view){
            super(view);
            screenShot = (ImageView) view.findViewById(R.id.screenshot);
            title = (TextView) view.findViewById(R.id.title);
            player = (TextView) view.findViewById(R.id.player);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Picasso.with(context).load(videos.getStreams().get(position).getPreview().getMedium()).into(holder.screenShot);
        holder.player.setText(videos.getStreams().get(position).getChannel().getDisplayName());
        holder.title.setText(videos.getStreams().get(position).getChannel().getStatus());
        holder.screenShot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TwitchActivity.launchActivity(fromActivity, videos.getStreams().get(position), videos.getStreams().get(position).getChannel().getDisplayName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return videos.getStreams().size();
    }
}
