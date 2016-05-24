package com.infi.overwatch.overwatchandroid.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.infi.overwatch.overwatchandroid.Adapter.NewsAdapter;
import com.infi.overwatch.overwatchandroid.Dao.DataStore;
import com.infi.overwatch.overwatchandroid.Dao.Gateway;
import com.infi.overwatch.overwatchandroid.Dao.RestClient;
import com.infi.overwatch.overwatchandroid.Listener.EndlessRecyclerListener;
import com.infi.overwatch.overwatchandroid.R;
import com.infi.overwatch.overwatchandroid.model.table.Result;
import com.infi.overwatch.overwatchandroid.model.table.Table;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TQi on 5/18/16.
 */
public class NewsFragment extends android.support.v4.app.Fragment {
    public static final String PAGE_TITLE = "PAGE_TITLE";
    public static final String TAG = "NEWS_FRAGMENT";
    private String pageTitle = "";
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ProgressBar progressBar;
    private NewsAdapter mNewsAdapter;
    private String title;
    private int index = 1;
    private int previousPage = 1;
    //max items can get from server
    private int maxSize = 0;

    public static NewsFragment newInstance(String title){
        Bundle arg = new Bundle();
        arg.putString(PAGE_TITLE, title);
        NewsFragment newsFragment = new NewsFragment();
        newsFragment.setArguments(arg);
        return newsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageTitle = getArguments().getString(PAGE_TITLE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        mRecycleView = (RecyclerView) view.findViewById(R.id.resultView);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        mRecycleView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecycleView.setLayoutManager(mLayoutManager);
        _buildScrollListener();
        getResults(pageTitle, "1");
        return view;
    }

    private void getResults(final String title, final String pageIndex){

        Gateway gateway = RestClient.getGateway();
        Log.i("language", Locale.getDefault().getLanguage());
        Call<Table> tableCall = gateway.getTable(title, pageIndex, Locale.getDefault().getLanguage());
        tableCall.enqueue(new Callback<Table>() {
            @Override
            public void onResponse(Call<Table> call, Response<Table> response) {

                if (response.body() != null) {
                    if (Integer.parseInt(pageIndex) == 1) {
                        DataStore.setNewsStore((ArrayList) response.body().getResults());
                        _setAdapter((ArrayList) response.body().getResults(), title, response.body().getCount());
                    } else {
                        ArrayList<Result> results = DataStore.getNewsStore();
                        results.addAll((ArrayList) response.body().getResults());
                        DataStore.setNewsStore(results);
                        mNewsAdapter.addResults((ArrayList) response.body().getResults(), Integer.parseInt(pageIndex));
                        mNewsAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<Table> call, Throwable t) {
                Log.i("error", t.toString());
            }
        });
    }

    private void _setAdapter(ArrayList<Result> results, String title, int max){
        progressBar.setVisibility(View.GONE);
        mNewsAdapter = new NewsAdapter(results, getActivity().getApplicationContext(), getActivity(), title);
        mRecycleView.setAdapter(mNewsAdapter);
        maxSize = max;
        mNewsAdapter.notifyDataSetChanged();
    }

    public void refreshView(){
        previousPage = 1;
        maxSize = 0;
        progressBar.setVisibility(View.VISIBLE);
        getResults(pageTitle, "1");
        _buildScrollListener();
    }

    private void _buildScrollListener(){
        mRecycleView.addOnScrollListener(new EndlessRecyclerListener((LinearLayoutManager)mLayoutManager){
            @Override
            public void onLoadMore(int current_page) {
                if(current_page != previousPage){
                    previousPage = current_page;
                }else{
                    return;
                }
                if(maxSize > DataStore.getNewsStore().size()){
                    getResults(pageTitle, Integer.toString((current_page - 1) * 10 + 1));
                }
            }
        });
    }
}
