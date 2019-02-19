package serdar.oz.coinkeeper.utils;


import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class BaseApplication extends Application {

    private SharedPreferences mSharedPreferences;
    private static BaseApplication sInstance = null;


    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }


    public static BaseApplication getInstance() {
        return sInstance;
    }


    public SharedPreferences getSharedPreferences() {
        return this.mSharedPreferences;
    }

}