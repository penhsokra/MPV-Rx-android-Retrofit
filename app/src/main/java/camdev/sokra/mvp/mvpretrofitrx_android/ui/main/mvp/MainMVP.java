package camdev.sokra.mvp.mvpretrofitrx_android.ui.main.mvp;

import java.util.List;

import camdev.sokra.mvp.mvpretrofitrx_android.model.Articles;

public interface MainMVP {

    interface View{
        void onShowLoading();
        void onHideLoading();
        void reqestDataSuccess(List<Articles> articles);
        void reqestDataComplet(String message);
        void reqestDataFail(String message);
    }

    interface Presenter{
        void onLoadingData();
        void setView(View view);
    }

    interface Interactor{
        void onRespone( InteractorRespone interactorRespone);

        interface InteractorRespone{
            void onSuccess(List<Articles> articles);
            void onComplete(String message);
            void onError(String message);
        }
    }

}
