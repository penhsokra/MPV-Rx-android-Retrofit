package camdev.sokra.mvp.mvpretrofitrx_android.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import camdev.sokra.mvp.mvpretrofitrx_android.adapter.MainAdapter;
import camdev.sokra.mvp.mvpretrofitrx_android.model.Articles;
import camdev.sokra.mvp.mvpretrofitrx_android.model.Source;
import camdev.sothoeun.asia.mvpretrofitrx_android.R;

public class DetailFragment extends Fragment {
    View view;
    TextView dtitle;
    ImageView dImage;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.detail_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





    }


    private static final String TAG = "DetailFragment";
    public void setMessage(Articles articles) {
        dImage = view.findViewById(R.id.dImage);
        dtitle = view.findViewById(R.id.dTitle);

        Glide.with(this).load(articles.getUrlToImage()).thumbnail(Glide.with(this).load(R.drawable.loading_img)).into(dImage);
        dtitle.setText(articles.getDescription());
    }
}
