package camdev.sokra.mvp.mvpretrofitrx_android.ui.main.mvp;

import camdev.sokra.mvp.mvpretrofitrx_android.auth.AuthServiceGenerator;
import camdev.sokra.mvp.mvpretrofitrx_android.model.respone.ArticlesRespone;
import camdev.sokra.mvp.mvpretrofitrx_android.service.NewsService;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class MainInteractor implements MainMVP.Interactor{

    NewsService newsService;

    public MainInteractor() {
        this.newsService = newsService;
    }

    CompositeDisposable disposable = new CompositeDisposable();
    @Override
    public void onRespone(final InteractorRespone interactorRespone) {

        newsService = AuthServiceGenerator.creatService(NewsService.class);

        Flowable<ArticlesRespone> flowable = newsService.getResultArticle();
            disposable.add(
            flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ArticlesRespone>(){

                    @Override
                    public void onNext(ArticlesRespone articlesRespone) {
                        interactorRespone.onSuccess(articlesRespone.getArticles());
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
