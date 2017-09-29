package app.android.floupr.elgroup.push;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import app.android.floupr.elgroup.common.Config;
import app.android.floupr.elgroup.common.UserPreference;
import app.android.floupr.elgroup.stickerapp.StickerApp;


/**
 * Created by VIKRAM SINGH on 13-Feb-17.
 */

public class FCMInitializationService extends FirebaseInstanceIdService {
    private static final String TAG = "FCMToken";
    UserPreference preference;

    public FCMInitializationService(){}

    @Override
    public void onTokenRefresh() {
        String fcmToken = FirebaseInstanceId.getInstance().getToken();
        preference = StickerApp.getInstance().getPreference();
        Log.d(TAG, "FCM DeviceToken:" + fcmToken);

        //Save or send FCM registration token

        if(fcmToken!= null)
        preference.saveData(Config.KeyName.USER_DEVICE_TOKEN, fcmToken);
    }
}
