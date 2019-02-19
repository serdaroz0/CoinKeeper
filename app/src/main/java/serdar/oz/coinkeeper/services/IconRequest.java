package serdar.oz.coinkeeper.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IconRequest {
    private static final String ICONS_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/";
    private static Retrofit retrofit = null;


    public static Retrofit getApiClient() {
        if (retrofit == null) {
            try {
                retrofit = new Retrofit.Builder().baseUrl(ICONS_URL).addConverterFactory(GsonConverterFactory.create()).build();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return retrofit;
    }


}

