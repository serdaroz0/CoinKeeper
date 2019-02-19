package serdar.oz.coinkeeper.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import serdar.oz.coinkeeper.R;
import serdar.oz.coinkeeper.activities.NewsDetailActivity;
import serdar.oz.coinkeeper.models.news.NewsModel;

import static serdar.oz.coinkeeper.utils.Util.UtfDecoder;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private ArrayList<NewsModel> news;
    private Context context;
    private boolean fromMain;

    public NewsAdapter(ArrayList<NewsModel> news, Context context, boolean fromMain) {
        this.news = new ArrayList<>(news);
        this.context = context;
        this.fromMain = fromMain;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitleNews)
        TextView tvTitleNews;
        @BindView(R.id.cvNews)
        CardView cvNews;
        @BindView(R.id.tvBodyNews)
        TextView tvBodyNews;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsModel newsModel = news.get(position);
        holder.tvTitleNews.setText(newsModel.getTitle());
        holder.tvBodyNews.setText(UtfDecoder(newsModel.getBody()));
        holder.cvNews.setOnClickListener(v -> {
            Intent intent = new Intent(context, NewsDetailActivity.class);
            intent.putExtra("title", newsModel.getTitle());
            intent.putExtra("body", newsModel.getBody());
            intent.putExtra("image", newsModel.getImageurl());
            intent.putExtra("date", newsModel.getPublished_on());
            intent.putExtra("url", newsModel.getUrl());
            intent.putExtra("categories", newsModel.getCategories());
            intent.putExtra("source", newsModel.getNewsSourceInfo().getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return news == null ? 0 : fromMain ? 3 : news.size();
    }


}
