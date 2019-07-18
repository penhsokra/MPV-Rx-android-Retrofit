package camdev.sokra.mvp.mvpretrofitrx_android.service;

import camdev.sokra.mvp.mvpretrofitrx_android.model.Source;
import camdev.sokra.mvp.mvpretrofitrx_android.model.SourcesArticles;
import camdev.sokra.mvp.mvpretrofitrx_android.model.respone.ArticlesRespone;
import camdev.sokra.mvp.mvpretrofitrx_android.model.respone.SourcesArticlesRespone;
import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface NewsService {
    @GET("v2/everything?q=apple&from=2019-07-17&to=2019-07-17&sortBy=popularity&apiKey=42d00460aa81487699ea3d8652983421")
    Flowable<ArticlesRespone> getResultArticle();

    @GET("/v2/sources?apiKey=42d00460aa81487699ea3d8652983421")
    Flowable<SourcesArticlesRespone> getResulSource();
}
