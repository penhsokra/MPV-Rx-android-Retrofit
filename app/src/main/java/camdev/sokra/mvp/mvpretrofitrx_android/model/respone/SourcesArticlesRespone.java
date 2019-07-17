package camdev.sokra.mvp.mvpretrofitrx_android.model.respone;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import camdev.sokra.mvp.mvpretrofitrx_android.model.SourcesArticles;
import retrofit2.http.GET;

public class SourcesArticlesRespone {
    private String status;
    @SerializedName("sources")
    private List<SourcesArticles> sourcesArticles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SourcesArticles> getSourcesArticles() {
        return sourcesArticles;
    }

    public void setSourcesArticles(List<SourcesArticles> sourcesArticles) {
        this.sourcesArticles = sourcesArticles;
    }

    @Override
    public String toString() {
        return "SourcesArticlesRespone{" +
                "status='" + status + '\'' +
                ", sourcesArticles=" + sourcesArticles +
                '}';
    }
}
