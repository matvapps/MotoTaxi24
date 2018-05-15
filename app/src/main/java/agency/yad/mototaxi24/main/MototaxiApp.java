package agency.yad.mototaxi24.main;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.onesignal.OneSignal;

import agency.yad.mototaxi24.R;

/**
 * Created by Alexandr
 */

public class MototaxiApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Context context = getApplicationContext();

        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);




        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }
}
