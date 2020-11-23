package com.example.android.news.landing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android.news.R;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder>  {

    List<NewsObject> newsObjects = new ArrayList<>();
    Context mCotenxt;
    private NewsViewHolder.NewsItemClick newsItemClick;

    public NewsAdapter(Context cotenxt, NewsViewHolder.NewsItemClick newsItemClick, List<NewsObject> mlist){
        this.mCotenxt = cotenxt;
        this.newsItemClick = newsItemClick;
        this.newsObjects = mlist;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_news_item, parent, false);
        return new NewsViewHolder(view, newsItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder viewHolder, int position) {
        NewsViewHolder holder = (NewsViewHolder) viewHolder;
        holder.setUpViews(newsObjects.get(position));
    }

    @Override
    public int getItemCount() {
        return newsObjects.size();
    }

}
