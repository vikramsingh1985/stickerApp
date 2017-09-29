package app.android.floupr.elgroup.push;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import app.android.floupr.elgroup.activities.MainActivity;
import app.android.floupr.elgroup.stickerapp.R;


/**
 * Created by VIKRAM SINGH on 13-Feb-17.
 */

public class FCMMessageHandler extends FirebaseMessagingService {

    private static final String TAG = "FCMMessage";
   // private NotificationTarget notificationTarget;
    @Override
    public void onMessageReceived(RemoteMessage fcmMessage) {
        //message will contain the Push Message
        Log.d("Floupr Message: ",""+fcmMessage);
        /*GiftNotification notification = new GiftNotification();
        notification.setTitle(fcmMessage.getData().get("title"));
        notification.setMessage(fcmMessage.getData().get("message"));
        notification.setDrinks(fcmMessage.getData().get("drinks"));
        notification.setFriendsName(fcmMessage.getData().get("friend"));
        notification.setImage(fcmMessage.getData().get("image"));
        notification.setSound(fcmMessage.getData().get("sound"));
        notification.setVibrate(fcmMessage.getData().get("vibrate"));*/

        //To get a Bitmap image from the URL received

        sendNotification(fcmMessage);
    }

    /**
     * Create and show a simple notification containing the received FCM message.
     */

    private void sendNotification(RemoteMessage fcmMessage) {
        Intent intent = new Intent(this, MainActivity.class);
         Bundle extras = new Bundle();
        if(fcmMessage.getData().containsKey("date"))
         extras.putString("date", fcmMessage.getData().get("date"));
        int color = ContextCompat.getColor(this, R.color.colorAccent);
       // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.setFlags((Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtras(extras);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle(fcmMessage.getData().get("title"))
                .setContentText(fcmMessage.getData().get("message"))
                .setAutoCancel(true)
                .setColor(color)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());
    }


}
