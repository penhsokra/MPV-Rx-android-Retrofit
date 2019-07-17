package camdev.sokra.mvp.mvpretrofitrx_android.model.respone;

import java.util.List;

import camdev.sokra.mvp.mvpretrofitrx_android.model.Articles;

public class ArticlesRespone {
    private String status;
    private int totalResults;
    private List<Articles> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "ArticlesRespone{" +
                "status='" + status + '\'' +
                ", totalResults=" + totalResults +
                ", articles=" + articles +
                '}';
    }
}