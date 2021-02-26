package com.efurture.notication.manager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.efurture.delaynotification.app.R;

public class NotificationHelper {

    private static String CHANNEL_ID = "com.efurture.delaynotification.app.notication";

    private static int nextId = 100;

    public static void sendNotificaiton(Context context, String title, String content){

        Uri sound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + context.getPackageName() +  R.raw.play_paiban);


        NotificationManagerCompat compat = NotificationManagerCompat.from(context);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();
            NotificationChannel channel = null;
            channel = new NotificationChannel(CHANNEL_ID , "阅读通知", NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableVibration(true);
            channel.setSound(sound, audioAttributes);
            NotificationManagerCompat.from(context).createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle(title);
        builder.setContentText(content + content + content);
       // builder.setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND);
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle().bigText(content).setBigContentTitle(title);


        Uri alertSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);



        builder.setStyle(bigTextStyle);
        builder.setSound(sound);
        builder.setAutoCancel(true);

        //builder.setSound(alertSound);

        Notification notification = builder.build();
        compat.notify(nextId, notification);
        nextId++;
    }
}
