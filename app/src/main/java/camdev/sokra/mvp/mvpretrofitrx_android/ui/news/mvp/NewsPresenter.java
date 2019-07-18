package camdev.sokra.mvp.mvpretrofitrx_android.ui.news.mvp;

import android.widget.Toast;

import java.util.List;

import camdev.sokra.mvp.mvpretrofitrx_android.model.SourcesArticles;

public class NewsPresenter implements NewsMVP.Presenter{
    private NewsMVP.Interactor interactor;
    private NewsMVP.View view;
    public NewsPresenter() {
        this.interactor = new NewsInteractor();
    }

    @Override
    public void onLoadingData() {
        view.onShowLoading();
        interactor.onRespone(new NewsMVP.Interactor.InteractorRespone() {
            @Override
            public void onSuccess(List<SourcesArticles> articles) {
                view.onHideLoading();
                view.reqestDataSuccess(articles);
            }

            @Override
            public void onError(String message) {
                view.onHideLoading();
                view.reqestDataFail(message);
            }

            @Override
            public void onComplete(String message) {
                view.reqestDataComplet(message);
            }
        });
    }

    @Override
    public void setView(NewsMVP.View view) {
        this.view = view;
    }
}
