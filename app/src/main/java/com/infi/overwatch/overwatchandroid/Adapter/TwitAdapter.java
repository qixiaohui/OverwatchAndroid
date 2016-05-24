package com.infi.overwatch.overwatchandroid.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.infi.overwatch.overwatchandroid.Activity.TwitterWebActivity;
import com.infi.overwatch.overwatchandroid.R;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TQi on 5/19/16.
 */
public class TwitAdapter extends RecyclerView.Adapter<TwitAdapter.ViewHolder> {
    private Activity activity;
    private Context context;
    private List<Tweet> tweets = new ArrayList<>();
    public TwitAdapter(Activity fromActivity, Context context, List<Tweet> tweetList){
        this.activity = fromActivity;
        this.context = context;
        this.tweets = tweetList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView author;
        TextView title;
        TextView date;
        ImageView tweetImg;
        LinearLayout twitCard;
        public ViewHolder(View view){
            super(view);
            author = (TextView) view.findViewById(R.id.author);
            title = (TextView) view.findViewById(R.id.title);
            date = (TextView) view.findViewById(R.id.date);
            tweetImg = (ImageView) view.findViewById(R.id.tweetImg);
            twitCard = (LinearLayout) view.findViewById(R.id.twitCard);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.twit_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Tweet tweet = tweets.get(position);
        holder.author.setText(tweet.user.screenName);
        holder.title.setText(tweet.text);
        holder.date.setText(tweet.createdAt);
        Picasso.with(context).load(tweet.user.profileImageUrl.replace("_normal","")).into(holder.tweetImg);
        holder.twitCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TwitterWebActivity.launchActivity(activity, tweet);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }
}
