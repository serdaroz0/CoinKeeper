package serdar.oz.coinkeeper.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.net.URLDecoder;

import serdar.oz.coinkeeper.R;

public class Util {
    public static String UtfDecoder(String data) {
        try {
            data = data.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
            data = data.replaceAll("\\+", "%2B");
            data = URLDecoder.decode(data, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    private static void showToast(Context context, int message) {
        showToast(context, context.getString(message));
    }


    private static void showToast(Context context, String message) {
        Toast t = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        //t.setGravity(Gravity.CENTER, 0, 0);
        t.show();
    }

    public static void errorMessage(Context context, int code) {
        switch (code) {
            case 404:
                showToast(context, R.string.error_404);
                break;
            case 500:
                showToast(context, R.string.error_500);
                break;
            default:
                showToast(context, R.string.error_default);
                break;
        }
    }

    public static void networkErrorMessage(Context context) {
        showToast(context, R.string.error_network);
    }

    public static ProgressDialog showProgressDialog(Context context) {
        ProgressDialog progressDialog = ProgressDialog.show(context, null, null);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setContentView(R.layout.progress_dialog);
        return progressDialog;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

//    public static OkHttpClient cacheParameters() {
//
//        return client;
//    }

}
