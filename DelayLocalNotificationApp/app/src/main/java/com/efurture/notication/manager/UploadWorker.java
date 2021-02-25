package com.efurture.notication.manager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class UploadWorker extends Worker {

    public UploadWorker( Context context, WorkerParameters params) {
        super(context, params);
    }

    @Override
    public Result doWork() {

        // Do the work here--in this case, upload the images.
        //uploadImages();
        Log.e("DelayNotification", "DelayNotification Worker " + Thread.currentThread()
        + "  getName " + Thread.currentThread().getName());

        // Indicate whether the work finished successfully with the Result
        return Result.success();
    }

}
