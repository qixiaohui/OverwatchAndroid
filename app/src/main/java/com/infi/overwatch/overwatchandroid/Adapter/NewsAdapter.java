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

import com.infi.overwatch.overwatchandroid.Activity.WebContentActivity;
import com.infi.overwatch.overwatchandroid.R;
import com.infi.overwatch.overwatchandroid.model.table.Result;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by TQi on 5/18/16.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private ArrayList<Result> results = new ArrayList<>();
    private Context mContext;
    private Activity fromActivity;
    private String mTitle;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public ImageView poster;
        public LinearLayout bigButton;
        public TextView author;
        public TextView domain;
        public ViewHolder(View v){
            super(v);
            title = (TextView) v.findViewById(R.id.title);
            poster = (ImageView) v.findViewById(R.id.poster);
            bigButton = (LinearLayout) v.findViewById(R.id.bigButton);
            author = (TextView) v.findViewById(R.id.author);
            domain = (TextView) v.findViewById(R.id.domain);
        }
    }

    public NewsAdapter(ArrayList<Result> results, Context context, Activity activity, String title){
        this.results = results;
        mContext = context;
        fromActivity = activity;
        mTitle = title;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.title.setText(results.get(position).getTitle());
        if(results.get(position).getIurl() != null && !results.get(position).getIurl().equals("") ){
            Picasso.with(mContext).load(results.get(position).getIurl()).into(holder.poster);
        }else{
            Picasso.with(mContext).load(R.drawable.default_news_bg).into(holder.poster);
        }

        if(!results.get(position).getAuthor().equals("no")){
            holder.author.setText(results.get(position).getAuthor());
            holder.author.setVisibility(View.VISIBLE);
        }

        if(results.get(position).getDomain() != null){
            holder.domain.setText(results.get(position).getDomain());
            holder.domain.setVisibility(View.VISIBLE);
        }
        holder.bigButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebContentActivity.launchActivity(fromActivity, results.get(position), "overwatch");
            }
        });
    }

    public void addResults(ArrayList<Result> moreResults, int index){
        if(index >= this.results.size()) {
            this.results.addAll(moreResults);
        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
