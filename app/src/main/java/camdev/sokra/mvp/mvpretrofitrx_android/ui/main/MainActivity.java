package camdev.sokra.mvp.mvpretrofitrx_android.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import camdev.sokra.mvp.mvpretrofitrx_android.auth.AuthServiceGenerator;
import camdev.sokra.mvp.mvpretrofitrx_android.model.Source;
import camdev.sokra.mvp.mvpretrofitrx_android.model.SourcesArticles;
import camdev.sokra.mvp.mvpretrofitrx_android.model.respone.ArticlesRespone;
import camdev.sokra.mvp.mvpretrofitrx_android.model.respone.SourcesArticlesRespone;
import camdev.sokra.mvp.mvpretrofitrx_android.service.NewsService;
import camdev.sokra.mvp.mvpretrofitrx_android.ui.news.mvp.NewsMVP;
import camdev.sokra.mvp.mvpretrofitrx_android.ui.news.mvp.NewsPresenter;
import camdev.sothoeun.asia.mvpretrofitrx_android.R;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class MainActivity extends AppCompatActivity {
    NewsService newsService;
    CompositeDisposable disposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsService = AuthServiceGenerator.creatService(NewsService.class);

        //resultArticle();
        //resulSource();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }

    private void resultArticle(){
        Flowable<ArticlesRespone> flowable = newsService.getResultArticle();
        disposable.add(
          flowable.subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribeWith(new DisposableSubscriber<ArticlesRespone>(){

              @Override
              public void onNext(ArticlesRespone articlesRespone) {
                  Log.e("1111","onNext:"+articlesRespone.getArticles());
              }

              @Override
              public void onError(Throwable t) {
                  Log.e("1111","Error:"+t.toString());
              }

              @Override
              public void onComplete() {
                  Log.e("1111","onComplete :");
              }
          })
        );
    }


}