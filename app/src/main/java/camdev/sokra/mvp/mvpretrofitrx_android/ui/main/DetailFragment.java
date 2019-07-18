package camdev.sokra.mvp.mvpretrofitrx_android.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import camdev.sokra.mvp.mvpretrofitrx_android.adapter.MainAdapter;
import camdev.sokra.mvp.mvpretrofitrx_android.model.Articles;
import camdev.sokra.mvp.mvpretrofitrx_android.model.Source;
import camdev.sothoeun.asia.mvpretrofitrx_android.R;

public class DetailFragment extends Fragment{
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.detail_fragment,container,false);
        return view;
    }

}
