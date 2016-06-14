package com.infi.overwatch.overwatchandroid.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.infi.overwatch.overwatchandroid.Adapter.PhotoAdapter;
import com.infi.overwatch.overwatchandroid.Dao.Gateway;
import com.infi.overwatch.overwatchandroid.Dao.RestClient;
import com.infi.overwatch.overwatchandroid.R;
import com.infi.overwatch.overwatchandroid.model.heros.Heros;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TQi on 5/18/16.
 */
public class PhotoFragment extends Fragment {
    public static final String TAG = "PHOTOT_FRAGMNET";
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private PhotoAdapter photoAdapter;
    private ArrayList<Heros> heros;

    public static PhotoFragment newInstance(){
        PhotoFragment photoFragment = new PhotoFragment();
        return photoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_photo, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        loadheros();
        return view;
    }

    private void loadheros(){

        Gateway gateway = RestClient.getAwsGateway();
        gateway.getHeros().enqueue(new Callback<ArrayList<Heros>>() {
            @Override
            public void onResponse(Call<ArrayList<Heros>> call, Response<ArrayList<Heros>> response) {
                heros = response.body();
                progressBar.setVisibility(View.INVISIBLE);
                recyclerView.setAdapter(new PhotoAdapter(heros, getContext(), getActivity()));
            }

            @Override
            public void onFailure(Call<ArrayList<Heros>> call, Throwable t) {
                Log.e("HTTP ERROR", t.toString());
            }
        });
    }

}
