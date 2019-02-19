package serdar.oz.coinkeeper.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import serdar.oz.coinkeeper.R;

public class NewsDetailActivity extends AppCompatActivity {
    String title, body, dateText, url, categories, source, image;
    Long date;
    @BindView(R.id.tvBodyNews)
    TextView tvBodyNews;
    @BindView(R.id.tvTitleNews)
    TextView tvTitleNews;
    @BindView(R.id.tvCategoryNews)
    TextView tvCategoryNews;
    @BindView(R.id.btnUrlNews)
    Button btnUrlNews;
    @BindView(R.id.ivImageNews)
    ImageView ivImageNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title = extras.getString("title", "");
            body = extras.getString("body", "");
            image = extras.getString("image", "");
            date = extras.getLong("date", 0);
            url = extras.getString("url", "");
            categories = extras.getString("categories", "");
            source = extras.getString("source", "");
        }
        Date d = new Date(date * 1000L);
        dateText = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(d);
        tvBodyNews.setText(getString(R.string.body_news, body, dateText, source));
        tvTitleNews.setText(title);
        tvCategoryNews.setText(categories);
        if (!image.equals("")) {
            try {
                CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(this);
                circularProgressDrawable.setStrokeWidth(8f);
                circularProgressDrawable.setCenterRadius(64f);
                circularProgressDrawable.setColorSchemeColors(Color.BLACK);
                circularProgressDrawable.start();
                Glide.with(this).load(image).apply(new RequestOptions()
                        .centerCrop()
                        .placeholder(circularProgressDrawable)
                        .error(R.drawable.ic_investor)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .priority(Priority.HIGH)).into(ivImageNews);
                ivImageNews.setScaleType(ImageView.ScaleType.FIT_XY);
            } catch (Exception ex) {
                //pass
            }
        }
    }

    @OnClick(R.id.btnUrlNews)
    void openUrl(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(source);
        WebView wv = new WebView(this);
        wv.loadUrl(url);
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        alert.setView(wv);
        alert.setNegativeButton(R.string.close, (dialog, id) -> dialog.dismiss());
        alert.show();
    }

    public void backPressed(View view) {
        onBackPressed();
    }
}
