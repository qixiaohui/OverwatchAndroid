package com.infi.overwatch.overwatchandroid.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.infi.overwatch.overwatchandroid.Adapter.VideoAdapter;
import com.infi.overwatch.overwatchandroid.Dao.Gateway;
import com.infi.overwatch.overwatchandroid.Dao.RestClient;
import com.infi.overwatch.overwatchandroid.R;
import com.infi.overwatch.overwatchandroid.model.Video.Videos;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TQi on 5/18/16.
 */
public class VideoFragment extends Fragment {
    public static final String TAG = "VIDEO_FRAGMENT";
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private Videos videos;
    private RecyclerView.LayoutManager mLayoutManager;

    public static VideoFragment newInstance(){
        VideoFragment videoFragment = new VideoFragment();
        return videoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_video, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        _loadVideos();
        return view;
    }

    private void _loadVideos(){
        Gateway gateway = RestClient.getTwitchGateway();
        gateway.getVideos().enqueue(new Callback<Videos>() {
            @Override
            public void onResponse(Call<Videos> call, Response<Videos> response) {
                videos = response.body();
                progressBar.setVisibility(View.INVISIBLE);
                _loadRows();
            }

            @Override
            public void onFailure(Call<Videos> call, Throwable t) {
                Log.e("HTTP ERROE", t.toString());
            }
        });
    }

    private void _loadRows(){
        recyclerView.setAdapter(new VideoAdapter(videos, getActivity(), getActivity().getApplicationContext()));

    }
}
