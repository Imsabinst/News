package com.example.android.news.landing;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.news.R;
import com.example.android.news.landing.news_in_detail.NewsDetailActivity;

import java.util.ArrayList;
import java.util.List;


public class NewsActivity extends AppCompatActivity implements NewsViewHolder.NewsItemClick {
    RecyclerView recyclerView;
    List<NewsObject> mlist = new ArrayList<>();
    NewsAdapter adapter;
    TextView app_bar_title;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_news);
            setupViews();

        app_bar_title = (TextView) findViewById(R.id.app_bar_title);
            app_bar_title.setText("Home");
        }

    private void setupViews() {
         recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
         mlist.clear();

         /**
          * Setting the data for the news object
          * **/
         mlist.add(new NewsObject("Sunset", R.drawable.nature,  "Mr. John","20 Nov 2020",
                 "CNN", "There are many variations of passages of Lorem Ipsum available," +
                 " but the majority have suffered alteration in some form, by injected humour, or" +
                 " randomised words which don't look even slightly believable. If you are going to " +
                 "use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing " +
                 "hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to " +
                 "repeat predefined chunks as necessary, making this the first true generator on the Internet." +
                 " It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, " +
                 "to generate Lorem Ipsum which looks reasonable." +
                 " The generated Lorem Ipsum is therefore always free from repetition, injected humour, " +
                 "or non-characteristic words etc."));

         mlist.add(new NewsObject("Fire on the forest", R.drawable.nature2,  "Mr. David","21 Nov 2020",
                 "BBC", "It is a long established fact that a reader will be distracted by the readable content" +
                 " of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal " +
                 "distribution of letters, as opposed to using 'Content here, content here', making it look like readable" +
                 " English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default " +
                 "model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. " +
                 "Various versions have evolved over the years, sometimes by accident, sometimes on purpose" +
                 " (injected humour and the like)."));
         mlist.add(new NewsObject("Sunny day", R.drawable.nature3,  "Mrs. Rita","19 Nov 2020",
                 "ABC", "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                 " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown " +
                 "printer took a galley of type and scrambled it to make a type specimen book. It has survived " +
                 "not only five centuries, but also the leap into electronic typesetting, remaining essentially " +
                 "unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem " +
                 "Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including " +
                 "versions of Lorem Ipsum."));
         mlist.add(new NewsObject("Greenery", R.drawable.nature4,  "Mr. David","21 Nov 2020",
                 "BBC", "It is a long established fact that a reader will be distracted by the readable " +
                 "content of a page when looking at its layout. The point of using Lorem Ipsum is that it has " +
                 "a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'," +
                 " making it look like readable English. Many desktop publishing packages and web page editors now " +
                 "use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web " +
                 "sites still in their infancy. Various versions have evolved over the years, sometimes by accident, " +
                 "sometimes on purpose (injected humour and the like)."));
         mlist.add(new NewsObject("Dummy Text", R.drawable.ic_launcher_foreground, "Mr. Dummy", "22 Nov 2020",
                 "DMM"));

         recyclerView.setLayoutManager(new LinearLayoutManager(NewsActivity.this));
         adapter = new NewsAdapter(getApplicationContext(), this, mlist);
         recyclerView.setAdapter(adapter);
         adapter.notifyDataSetChanged();
    }



    @Override
    public void onItemClick(int position) {
        Log.d("clicked", "OnItemClick: " + position);

        /**
         *
         * Setting the intents for the detail news activity with the related fields
         *
         *  **/
        Intent detailIntent = new Intent(getApplication(), NewsDetailActivity.class);
        detailIntent.putExtra("title", mlist.get(position).getTitle());
        detailIntent.putExtra("image", mlist.get(position).getImage());
        detailIntent.putExtra("author", mlist.get(position).getAuthor());
        detailIntent.putExtra("date", mlist.get(position).getDate());
        detailIntent.putExtra("source", mlist.get(position).getSource());
        detailIntent.putExtra("content", mlist.get(position).getContent());
        startActivity(detailIntent);

    }
}
