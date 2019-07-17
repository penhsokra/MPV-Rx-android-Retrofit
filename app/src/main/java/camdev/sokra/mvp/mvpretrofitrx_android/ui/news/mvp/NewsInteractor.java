package camdev.sokra.mvp.mvpretrofitrx_android.ui.news.mvp;

import android.util.Log;

import camdev.sokra.mvp.mvpretrofitrx_android.auth.AuthServiceGenerator;
import camdev.sokra.mvp.mvpretrofitrx_android.model.respone.SourcesArticlesRespone;
import camdev.sokra.mvp.mvpretrofitrx_android.service.NewsService;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class NewsInteractor implements NewsMVP.Interactor{

    NewsService newsService;

    public NewsInteractor() {
        this.newsService = newsService;
    }

    CompositeDisposable disposable = new CompositeDisposable();
    @Override
    public void onRespone(final InteractorRespone interactorRespone) {

        newsService = AuthServiceGenerator.creatService(NewsService.class);

        Flowable<SourcesArticlesRespone> flowable = newsService.getResulSource();
            disposable.add(
            flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<SourcesArticlesRespone>(){
                    @Override
                    public void onNext(SourcesArticlesRespone sourcesArticlesRespone) {
                        interactorRespone.onSuccess(sourcesArticlesRespone.getSourcesArticles());
                    }

                    @Override
                    public void onError(Throwable t) {
                        interactorRespone.onError("Loading Error");
                    }

                    @Override
                    public void onComplete() {
                        interactorRespone.onComplete("completed");
                    }
                })
            );
    }

}
