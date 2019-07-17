package camdev.sokra.mvp.mvpretrofitrx_android.auth;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthServiceGenerator {
    private static final String API_URL ="https://newsapi.org";
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    public static <S> S creatService(Class<S> creatServiceClass){
        return builder.build().create(creatServiceClass);
    }
}
