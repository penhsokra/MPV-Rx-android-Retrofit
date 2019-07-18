package camdev.sokra.mvp.mvpretrofitrx_android.adapter;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import camdev.sokra.mvp.mvpretrofitrx_android.model.Articles;
import camdev.sokra.mvp.mvpretrofitrx_android.model.Source;
import camdev.sokra.mvp.mvpretrofitrx_android.model.SourcesArticles;
import camdev.sothoeun.asia.mvpretrofitrx_android.R;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.Viewholder> {
    private List<Articles> articlesList;
    private AppCompatActivity context;
    private onCallBack onCallBack;
    public MainAdapter(List<Articles> articlesList, AppCompatActivity context) {
        this.articlesList = articlesList;
        this.context = context;
        this.onCallBack = (onCallBack) context;
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_news_list,viewGroup,false);
        return new MainAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, final int i) {
        final Articles articles = articlesList.get(i);
        Source source = articles.getSource();
        viewholder.title.setText(articles.getTitle());
        viewholder.author.setText(source.getName());
        viewholder.tvDate.setText(articles.getPublishedAt());
        Glide.with(context).load(articles.getUrlToImage()).thumbnail(Glide.with(context).load(R.drawable.loading_img)).into(viewholder.newImage);

        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCallBack.onItemSelected(articles);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    static class Viewholder extends RecyclerView.ViewHolder {
        private TextView title,author,tvDate;
        private ImageView newImage;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.newsTitle);
            author = itemView.findViewById(R.id.newsAuthor);
            tvDate = itemView.findViewById(R.id.tvDate);
            newImage = itemView.findViewById(R.id.newsImage);
        }
    }

    public void addMoreItem(List<Articles> atticles){
        int previousSize = getItemCount();
        this.articlesList.addAll(atticles);
        notifyItemRangeInserted(previousSize,this.articlesList.size());
    }

    public interface onCallBack{
        void onItemSelected(Articles articles);
    }
}
