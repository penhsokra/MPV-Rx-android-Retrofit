package camdev.sokra.mvp.mvpretrofitrx_android.ui.main;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import camdev.sokra.mvp.mvpretrofitrx_android.adapter.MainAdapter;
import camdev.sokra.mvp.mvpretrofitrx_android.adapter.NewsAdapter;
import camdev.sokra.mvp.mvpretrofitrx_android.model.Articles;
import camdev.sokra.mvp.mvpretrofitrx_android.model.Source;
import camdev.sokra.mvp.mvpretrofitrx_android.ui.main.mvp.MainMVP;
import camdev.sokra.mvp.mvpretrofitrx_android.ui.main.mvp.MainPresenter;
import camdev.sothoeun.asia.mvpretrofitrx_android.R;

public class MainActivity extends AppCompatActivity implements MainMVP.View, MainAdapter.onCallBack{
    ProgressBar myProgressBar;
    MainPresenter presenter;
    RecyclerView recyclerView;
    MainAdapter mainAdapter;
    List<Articles> articlesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myProgressBar = findViewById(R.id.myProgressBar);

        intiUI();
        presenter = new MainPresenter();
        presenter.setView(this);
        presenter.onLoadingData();
    }

    private void intiUI(){
        recyclerView = findViewById(R.id.recyclerNews);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //DividerItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        //itemDecoration.setDrawable(ContextCompat.getDrawable(this,R.drawable.border_divider_items_list));
        //recyclerView.addItemDecoration(itemDecoration);
        mainAdapter = new MainAdapter(articlesList,this);
        recyclerView.setAdapter(mainAdapter);
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
    public void reqestDataSuccess(List<Articles> articles) {
        mainAdapter.addMoreItem(articles);
    }

    @Override
    public void reqestDataComplet(String message) {
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void reqestDataFail(String message) {
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(Articles articles) {
        Toast.makeText(this, "Call back", Toast.LENGTH_SHORT).show();
    }
}