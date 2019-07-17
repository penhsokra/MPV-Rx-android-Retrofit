package camdev.sokra.mvp.mvpretrofitrx_android.ui.news.mvp;

import java.util.List;

public interface NewsMVP {
    interface View{
        void onShowLoading();
        void onHideLoading();
        void reqestDataSuccess(String message);
        void reqestDataFail(String message);
    }

    interface Presenter{
        void onLoadingData();
        void setView(View view);
    }

    interface Interactor{
        void onRespone( InteractorRespone interactorRespone);

        interface InteractorRespone{
            void onSuccess(String message);
            void onError(String message);
        }
    }

}
