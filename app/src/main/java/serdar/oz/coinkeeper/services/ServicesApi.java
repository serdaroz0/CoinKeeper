package serdar.oz.coinkeeper.services;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import serdar.oz.coinkeeper.models.coin.CoinModel;
import serdar.oz.coinkeeper.models.icon.IconModel;
import serdar.oz.coinkeeper.models.news.NewsModel;

public interface ServicesApi {
    @GET("news/")
    Call<ArrayList<NewsModel>> getNews();

    @GET("latest")
    @Headers("X-CMC_PRO_API_KEY: a016bac4-1811-43a4-b685-c581742e01fb")
    Call<CoinModel> getCoins();

    @GET("info?")
    @Headers("X-CMC_PRO_API_KEY: a016bac4-1811-43a4-b685-c581742e01fb")
    Call<IconModel> getIcon(@Query("id") String id);

}
