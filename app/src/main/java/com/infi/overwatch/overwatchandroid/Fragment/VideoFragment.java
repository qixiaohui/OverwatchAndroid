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
import android.widget.ProgressBar;

import com.infi.overwatch.overwatchandroid.Adapter.VideoAdapter;
import com.infi.overwatch.overwatchandroid.Dao.Gateway;
import com.infi.overwatch.overwatchandroid.Dao.RestClient;
import com.infi.overwatch.overwatchandroid.Listener.EndlessRecyclerListener;
import com.infi.overwatch.overwatchandroid.R;
import com.infi.overwatch.overwatchandroid.model.video.Data;
import com.infi.overwatch.overwatchandroid.model.video.VideoPayload;
import com.infi.overwatch.overwatchandroid.model.video.Videos;

import java.util.ArrayList;

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
    private RecyclerView.LayoutManager mLayoutManager;
    private int previousPage = 1;
    private int maxSize = 50; // default 50 as max videos

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
        loadVideos(1);
        buildScrollListener();
        return view;
    }

    private void loadVideos(final int index){
        Gateway gateway = RestClient.getAwsGateway();
        VideoPayload videoPayload = constructPayload(index);
        gateway.getVideos(videoPayload).enqueue(new Callback<ArrayList<Videos>>() {
            @Override
            public void onResponse(Call<ArrayList<Videos>> call, Response<ArrayList<Videos>> response) {
                if(index == 1) {
                    progressBar.setVisibility(View.INVISIBLE);
                    recyclerView.setAdapter(new VideoAdapter(response.body(), getActivity(), getActivity().getApplicationContext()));
                } else {
                    ((VideoAdapter)recyclerView.getAdapter()).addMoreVideos(response.body(), index);
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Videos>> call, Throwable t) {
                Log.e("HTTP ERROE", t.toString());
            }
        });
    }

    private VideoPayload constructPayload(int index) {
        VideoPayload videoPayload = new VideoPayload();
        Data data = new Data();
        data.setPageIndex(index);
        data.setSource("youtube");
        data.setVideoNum(12);
        videoPayload.setData(data);
        videoPayload.setTimeout(25000);

        return videoPayload;
    }

    private void buildScrollListener(){
        recyclerView.addOnScrollListener(new EndlessRecyclerListener((LinearLayoutManager) mLayoutManager){
            @Override
            public void onLoadMore(int current_page) {
                if(current_page != previousPage){
                    previousPage = current_page;
                }else{
                    return;
                }
                if(maxSize > recyclerView.getAdapter().getItemCount()){
                    loadVideos(current_page);
                }
            }
        });
    }
}
