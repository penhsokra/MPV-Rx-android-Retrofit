package camdev.sokra.mvp.mvpretrofitrx_android.ui.main.mvp;

import java.util.List;

import camdev.sokra.mvp.mvpretrofitrx_android.model.Articles;
import camdev.sokra.mvp.mvpretrofitrx_android.ui.main.mvp.MainMVP;

public class MainPresenter implements MainMVP.Presenter{
    private MainMVP.Interactor interactor;
    private MainMVP.View view;

    public MainPresenter() {
        this.interactor = new MainInteractor();
    }

    @Override
    public void onLoadingData() {
        view.onShowLoading();
        interactor.onRespone(new MainMVP.Interactor.InteractorRespone() {
            @Override
            public void onSuccess(List<Articles> articles) {
                view.onHideLoading();
                view.reqestDataSuccess(articles);
            }

            @Override
            public void onComplete(String message) {
                view.reqestDataComplet(message);
            }

            @Override
            public void onError(String message) {
                view.onHideLoading();
                view.reqestDataFail(message);
            }
        });
    }

    @Override
    public void setView(MainMVP.View view) {
        this.view = view;
    }
}
