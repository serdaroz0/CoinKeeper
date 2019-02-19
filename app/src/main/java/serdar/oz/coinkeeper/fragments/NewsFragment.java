package serdar.oz.coinkeeper.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import serdar.oz.coinkeeper.R;
import serdar.oz.coinkeeper.adapters.NewsAdapter;
import serdar.oz.coinkeeper.models.news.NewsModel;

public class NewsFragment extends Fragment {
    @BindView(R.id.rvNews)
    RecyclerView rvNews;
    ArrayList<NewsModel> newsModels = new ArrayList<>();
    NewsAdapter newsAdapter;
    private Unbinder unbinder;

    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
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
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getNews();
    }

    private void getNews() {
        newsModels = MainFragment.newsModels;
        rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvNews.setHasFixedSize(true);
        newsAdapter = new NewsAdapter(newsModels, getActivity(), false);
        rvNews.setAdapter(newsAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
