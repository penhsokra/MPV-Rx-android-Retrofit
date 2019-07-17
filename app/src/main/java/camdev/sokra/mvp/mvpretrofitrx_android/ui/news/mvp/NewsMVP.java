package camdev.sokra.mvp.mvpretrofitrx_android.ui.news.mvp;

import java.util.List;

import camdev.sokra.mvp.mvpretrofitrx_android.model.Articles;
import camdev.sokra.mvp.mvpretrofitrx_android.model.Source;
import camdev.sokra.mvp.mvpretrofitrx_android.model.SourcesArticles;

public interface NewsMVP {
    interface View{
        void onShowLoading();
        void onHideLoading();
        void reqestDataSuccess(List<SourcesArticles> articles);
        void reqestDataFail(String message);
    }

    interface Presenter{
        void onLoadingData();
        void setView(View view);
    }

    interface Interactor{
        void onRespone( InteractorRespone interactorRespone);

        interface InteractorRespone{
            void onSuccess(List<SourcesArticles> articles);
            void onError(String message);
            void onComplete(String message);
        }
    }

}
