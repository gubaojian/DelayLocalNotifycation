package com.efurture.notication.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class UploadWorker extends Worker {

    private Handler mMainHandler = new Handler(Looper.getMainLooper());

    public UploadWorker( Context context, WorkerParameters params) {
        super(context, params);
    }

    @Override
    public Result doWork() {

        // Do the work here--in this case, upload the images.
        //uploadImages();
        Log.e("DelayNotification", "DelayNotification Worker " + Thread.currentThread()
        + "  getName " + Thread.currentThread().getName());

        mMainHandler.post(new Runnable() {
            @Override
            public void run() {
                System.out.println("DelayNotification");
                String title = "排班通知";
                String content = "排班检查通知，排班检查通知，排班检查通知，排班检查通知，排班检查通知，排班检查通知，排班检查通知，排班检查通知，排班检查通知，排班检查通知，排班检查通知，排班检查通知，排班检查通知，排班检查通知，排班检查通知，排班检查通知";
                NotificationHelper.sendNotificaiton(getApplicationContext(), title, content);
            }
        });

        // Indicate whether the work finished successfully with the Result
        return Result.success();
    }

}
