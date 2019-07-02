package com.sujatapaul.sujatapaul;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class sBase {
    public static final String IS_REACHED_TOHOME="isHome",SERIALIZE_DATA="serialized_data",INTENT_DATA="transport_data",
            FILES_ARRAY="files_array";
    public static final int sPermission=100;

    public static boolean checkInternet(Application application){
        ConnectivityManager connectivityManager= (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=null;
        if(connectivityManager!=null){
            networkInfo= connectivityManager.getActiveNetworkInfo();
        }
        return networkInfo!=null && networkInfo.isConnected();
    }

    public static void requestForAllPermissions(Application application, Activity activity){
        ArrayList<String> permissions=new ArrayList<>();
        if(ActivityCompat.checkSelfPermission(application, Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED){
            permissions.add(Manifest.permission.INTERNET);
        }
        if(ActivityCompat.checkSelfPermission(application,Manifest.permission.ACCESS_NETWORK_STATE)!=PackageManager.PERMISSION_GRANTED){
            permissions.add(Manifest.permission.ACCESS_NETWORK_STATE);
        }
//        if(ActivityCompat.checkSelfPermission(application,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
//            permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        }
//        if(ActivityCompat.checkSelfPermission(application,Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
//            permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
//        }
//        if(ActivityCompat.checkSelfPermission(application,Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED){
//            permissions.add(Manifest.permission.CAMERA);
//        }
        if(permissions.size()>0){
            String[] permissionsAll=new String[permissions.size()];
            for (int i=0;i<permissions.size();i++){
                permissionsAll[i]=permissions.get(i);
            }
            ActivityCompat.requestPermissions(activity,permissionsAll,sPermission);
        }
    }
}
