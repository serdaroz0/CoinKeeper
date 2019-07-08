package serdar.oz.coinkeeper.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsRequest {
    public static final String NEWS_URL = "https://min-api.cryptocompare.com/data/";
    private static Retrofit retrofit = null;

    public static Retrofit getApiClient() {
        if (retrofit == null) {
            try {
                retrofit = new Retrofit.Builder().baseUrl(NEWS_URL).addConverterFactory(GsonConverterFactory.create()).build();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return retrofit;
        /*Test*/
    }


}
