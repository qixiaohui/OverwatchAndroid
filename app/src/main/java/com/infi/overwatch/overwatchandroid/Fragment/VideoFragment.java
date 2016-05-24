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
    private RecyclerView.LayoutManager mLayoutManager;
    private int previousPage = 1;
    private int maxSize = 0;

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
        Gateway gateway = RestClient.getTwitchGateway();
        gateway.getVideos(index).enqueue(new Callback<Videos>() {
            @Override
            public void onResponse(Call<Videos> call, Response<Videos> response) {
                if(index == 1) {
                    progressBar.setVisibility(View.INVISIBLE);
                    recyclerView.setAdapter(new VideoAdapter(response.body(), getActivity(), getActivity().getApplicationContext()));
                    maxSize = response.body().getTotal();
                }else{
                    ((VideoAdapter)recyclerView.getAdapter()).addMoreVideos(response.body(), index);
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Videos> call, Throwable t) {
                Log.e("HTTP ERROE", t.toString());
            }
        });
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
                    loadVideos((current_page - 1) * 25 + 1);
                }
            }
        });
    }
}
