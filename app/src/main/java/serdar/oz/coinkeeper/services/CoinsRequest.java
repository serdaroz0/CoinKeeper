package serdar.oz.coinkeeper.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoinsRequest {
    private static final String COINS_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/";
    private static Retrofit retrofit = null;


    public static Retrofit getApiClient() {
/*        long SIZE_OF_CACHE = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(new File(BaseApplication.getInstance().getCacheDir(), "http"), SIZE_OF_CACHE);
        OkHttpClient client = new OkHttpClient();
        client.cache();
        client.networkInterceptors().add(new CachingControlInterceptor());*/
        if (retrofit == null) {
            try {
                retrofit = new Retrofit.Builder().baseUrl(COINS_URL).addConverterFactory(GsonConverterFactory.create()).build();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return retrofit;
    }


}
