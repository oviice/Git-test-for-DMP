package com.timeshuttle.notificationtest;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import static android.content.Context.NOTIFICATION_SERVICE;

public class MyBroadcastReceiver extends BroadcastReceiver {

    static final String ACTION_SNOOZE = "OK";
    static final String EXTRA_NOTIFICATION_ID = "notification-id";

    private static final String TAG = "receiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Log.e(TAG, "onReceive");

        if (ACTION_SNOOZE.equals(intent.getAction())) {

            if (intent.getExtras() != null) {
                int notificationId = intent.getIntExtra(EXTRA_NOTIFICATION_ID, 0);

                Log.e(TAG, "Cancel notification with id " + notificationId);

                NotificationManager notificationmanager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
                notificationmanager.cancel(notificationId);
            } else {
                Log.e(TAG, "no extras");
            }

        }
    }
}
