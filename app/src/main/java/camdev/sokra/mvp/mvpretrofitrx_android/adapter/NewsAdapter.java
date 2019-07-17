package camdev.sokra.mvp.mvpretrofitrx_android.adapter;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import camdev.sokra.mvp.mvpretrofitrx_android.model.respone.SourcesArticlesRespone;
import camdev.sokra.mvp.mvpretrofitrx_android.ui.news.mvp.NewsMVP;
import camdev.sothoeun.asia.mvpretrofitrx_android.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.Viewholder> {
    private List<SourcesArticlesRespone> articlesRespones;
    private AppCompatActivity context;

    public NewsAdapter(List<SourcesArticlesRespone> articlesRespones, AppCompatActivity context) {
        this.articlesRespones = articlesRespones;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_list,viewGroup,false);
        return new NewsAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {
        final SourcesArticlesRespone articles = articlesRespones.get(i);
        viewholder.title.setText(articles.getStatus());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class Viewholder extends RecyclerView.ViewHolder {
        private TextView title;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.newsTitle);
        }
    }
}
