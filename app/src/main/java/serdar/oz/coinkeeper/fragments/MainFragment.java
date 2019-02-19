package serdar.oz.coinkeeper.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import serdar.oz.coinkeeper.R;
import serdar.oz.coinkeeper.adapters.CoinsAdapter;
import serdar.oz.coinkeeper.adapters.NewsAdapter;
import serdar.oz.coinkeeper.models.coin.CoinModel;
import serdar.oz.coinkeeper.models.coin.Datum;
import serdar.oz.coinkeeper.models.news.NewsModel;
import serdar.oz.coinkeeper.services.CoinsRequest;
import serdar.oz.coinkeeper.services.NewsRequest;
import serdar.oz.coinkeeper.services.ServicesApi;
import serdar.oz.coinkeeper.utils.Util;

import static android.support.constraint.Constraints.TAG;

public class MainFragment extends Fragment {
    private Unbinder unbinder;
    public static ArrayList<Datum> datum = new ArrayList<>();
    public static ArrayList<NewsModel> newsModels = new ArrayList<>();
    @BindView(R.id.coins)
    RecyclerView rvCoins;
    @BindView(R.id.news)
    RecyclerView rvNews;
    NewsAdapter newsAdapter;
    CoinsAdapter coinsAdapter;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getCoins();
        getNews();
    }


    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    private void getNews() {
        ProgressDialog progressDialog = Util.showProgressDialog(getActivity());
        ServicesApi news = NewsRequest.getApiClient().create(ServicesApi.class);
        Call<ArrayList<NewsModel>> call = news.getNews();
        call.enqueue(new Callback<ArrayList<NewsModel>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<NewsModel>> call, @NonNull Response<ArrayList<NewsModel>> response) {
                if (response.isSuccessful()) {
                    newsModels = response.body();
                    rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));
                    rvNews.setHasFixedSize(true);
                    newsAdapter = new NewsAdapter(newsModels, getActivity(), true);
                    rvNews.setAdapter(newsAdapter);
                } else
                    Util.errorMessage(getActivity(), response.code());
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<NewsModel>> call, @NonNull Throwable t) {
                progressDialog.dismiss();
                Log.d(TAG, "onResponse: " + t.getLocalizedMessage());
                Util.networkErrorMessage(getActivity());
            }
        });
    }

    private void getCoins() {
        ProgressDialog progressDialog = Util.showProgressDialog(getActivity());
        ServicesApi coins = CoinsRequest.getApiClient().create(ServicesApi.class);
        Call<CoinModel> call = coins.getCoins();
        call.enqueue(new Callback<CoinModel>() {
            @Override
            public void onResponse(@NonNull Call<CoinModel> call, @NonNull Response<CoinModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        CoinModel coinModels = response.body();
                        datum = (ArrayList<Datum>) coinModels.getData();
                        rvCoins.setLayoutManager(new LinearLayoutManager(getContext()));
                        rvCoins.setHasFixedSize(true);
                        coinsAdapter = new CoinsAdapter(datum, getActivity(), true);
                        rvCoins.setAdapter(coinsAdapter);
                    }
                } else
                    Util.errorMessage(getActivity(), response.code());
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(@NonNull Call<CoinModel> call, @NonNull Throwable t) {
                progressDialog.dismiss();
                Util.networkErrorMessage(getActivity());
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

}