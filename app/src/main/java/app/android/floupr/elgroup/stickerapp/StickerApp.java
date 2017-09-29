package app.android.floupr.elgroup.stickerapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import app.android.floupr.elgroup.common.UserPreference;

/**
 * Created by vikram on 24/9/17.
 */

public class StickerApp  extends Application{

    File file;
    public Activity currentActivity;
    public Context applicationContext;
    UserPreference userPreference;
    String LINE_SEPARATOR = "\n";
    static StickerApp singletonInstance;
    public HashMap<String, Activity> activitiesStack;

    @Override
    public void onCreate() {
        super.onCreate();
        singletonInstance = this;
        userPreference = new UserPreference(getApplicationContext());
        printHashKey();
    }
    public UserPreference getPreference() {
        return userPreference;
    }

    synchronized public void addActivityInStack(String key, Activity value) {
        try {
            if (activitiesStack == null) {
                activitiesStack = new HashMap<>();
            }
            currentActivity = value;
            activitiesStack.put(key, value);
        } catch (Exception e) {
            Log.e("Exception: ",""+e.getMessage());
        }
    }

    synchronized public static StickerApp getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new StickerApp();

        }

        return singletonInstance;
    }

    public void printHashKey(){
        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getApplicationContext().getPackageName(),
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", ""+ Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }
}
