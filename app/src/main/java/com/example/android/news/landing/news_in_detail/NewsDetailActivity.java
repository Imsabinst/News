package com.example.android.news.landing.news_in_detail;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.android.news.R;
import com.example.android.news.landing.NewsActivity;
import com.example.android.news.landing.NewsObject;

import org.w3c.dom.Text;

import butterknife.OnClick;


public class NewsDetailActivity extends AppCompatActivity {
    ImageView image_back;
    ImageView img_detailed_news;
    TextView title_detailed_news;
    TextView detailed_news_date;
    TextView detailed_description;
    TextView tv_detail_news_author;
    TextView tv_detail_news_source;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_in_detail);

        image_back = (ImageView) findViewById(R.id.image_back);
        img_detailed_news = (ImageView) findViewById(R.id.img_detailed_news);
        title_detailed_news = (TextView) findViewById(R.id.tv_detailed_news_title);
        detailed_news_date = (TextView) findViewById(R.id.tv_detailed_date);
        detailed_description = (TextView) findViewById(R.id.tv_detailed_description);
        tv_detail_news_author = (TextView) findViewById(R.id.tv_author);
        tv_detail_news_source = (TextView) findViewById(R.id.tv_source);


        //getting object data from another activity so serializable is used

        NewsObject newsObject = (NewsObject) getIntent().getSerializableExtra("newsobject");

        String title = "";
        String img_url = "";
        String author = "";
        String date = "";
        String source = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null ){
            title = extras.getString("title");
            img_url = extras.getString("image");
            author = extras.getString("author");
            date = extras.getString("date");
            source = extras.getString("source");
        }

        title_detailed_news.setText(title);
        Glide.with(getApplicationContext())
                .load(img_url)
                .apply(RequestOptions.centerCropTransform())
                .apply(RequestOptions.placeholderOf(R.drawable.nature))
                .into(img_detailed_news);

        tv_detail_news_author.setText(author);
        detailed_news_date.setText(date);
        tv_detail_news_source.setText(source);

        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);
            }
        });
    }
}
