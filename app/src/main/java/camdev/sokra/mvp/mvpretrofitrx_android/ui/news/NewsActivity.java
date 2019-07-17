package camdev.sokra.mvp.mvpretrofitrx_android.ui.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import camdev.sokra.mvp.mvpretrofitrx_android.adapter.NewsAdapter;
import camdev.sokra.mvp.mvpretrofitrx_android.model.respone.SourcesArticlesRespone;
import camdev.sokra.mvp.mvpretrofitrx_android.ui.news.mvp.NewsMVP;
import camdev.sokra.mvp.mvpretrofitrx_android.ui.news.mvp.NewsPresenter;
import camdev.sothoeun.asia.mvpretrofitrx_android.R;

public class NewsActivity extends AppCompatActivity implements NewsMVP.View{
    ProgressBar myProgressBar;
    NewsPresenter presenter;
    RecyclerView recyclerView;
    NewsAdapter newsAdapter;
    List<SourcesArticlesRespone> newList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        myProgressBar = findViewById(R.id.myProgressBar);

        intiUI();
        presenter = new NewsPresenter();
        presenter.setView(this);
        presenter.onLoadingData();

    }

    private void intiUI(){
        recyclerView = findViewById(R.id.recyclerNews);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsAdapter = new NewsAdapter(newList,this);
        recyclerView.setAdapter(newsAdapter);
    }

    @Override
    public void onShowLoading() {
        myProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHideLoading() {
        myProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void reqestDataSuccess(String message) {
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void reqestDataFail(String message) {
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }
}
