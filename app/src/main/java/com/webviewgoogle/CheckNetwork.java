package com.webviewgoogle;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class CheckNetwork {
    private static String TAG = CheckNetwork.class.getSimpleName();

    public static boolean isInternet(Context context){
        NetworkInfo info = (NetworkInfo) ((ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

        if (info == null){
            Log.d(TAG, "No internet connection");
            return false;
        }
        else{
            if (info.isConnected()){
                Log.d(TAG, "Internet connection available...");
            }
            else{
                Log.d(TAG, "Internet connection");
            }
            return true;
        }
    }
}
