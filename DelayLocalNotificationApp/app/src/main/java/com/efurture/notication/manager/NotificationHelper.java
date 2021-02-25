package com.efurture.notication.manager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.efurture.delaynotification.app.R;

public class NotificationHelper {

    private static String CHANNEL_ID = "com.efurture.delaynotification.app.notication";

    private static int nextId = 100;

    public static void sendNotificaiton(Context context, String title, String content){
        NotificationManagerCompat compat = NotificationManagerCompat.from(context);

        NotificationChannel channel = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            channel = new NotificationChannel(CHANNEL_ID , "阅读通知", NotificationManager.IMPORTANCE_DEFAULT);
        }
        NotificationManagerCompat.from(context).createNotificationChannel(channel);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle(title);
        builder.setContentText(content + content + content);



        builder.setAutoCancel(true);
        Notification notification = builder.build();
        compat.notify(nextId, notification);
        nextId++;
    }
}
