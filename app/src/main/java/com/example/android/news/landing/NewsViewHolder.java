package com.example.android.news.landing;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.news.R;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    ImageView iv_news_background;
    TextView tv_author;
    TextView tv_publishedAt;
    TextView tv_source;
    NewsItemClick newsItemClick;

    /**
     *
     * This interface will detect the click and this method is used in the NewsActivity
     * which will send the position of the clicked item.
     *
     * **/

    public interface NewsItemClick {
        void onItemClick(int position);
    }

    public NewsViewHolder(@NonNull View itemView, NewsItemClick newsItemClick) {
        super(itemView);
        this.newsItemClick = newsItemClick;

        /**
         *
         * Click listener for each news items
         *
         * **/
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (newsItemClick != null){
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        newsItemClick.onItemClick(position);
                    }
                }
            }
        });
    }

    public void setUpViews(NewsObject object) {
        title = (TextView) itemView.findViewById(R.id.tv_title);
        iv_news_background = (ImageView) itemView.findViewById(R.id.iv_news_background);
        tv_author = (TextView) itemView.findViewById(R.id.tv_author);
        tv_publishedAt = (TextView) itemView.findViewById(R.id.tv_publishedAt);
        tv_source = (TextView) itemView.findViewById(R.id.tv_source);

        title.setText(object.getTitle());
        iv_news_background.setImageResource(object.getImage());
        tv_author.setText("Author: " + object.getAuthor());
        tv_publishedAt.setText("Published Date: " + object.getDate());
        tv_source.setText("Source: " + object.getSource());
    }
}
