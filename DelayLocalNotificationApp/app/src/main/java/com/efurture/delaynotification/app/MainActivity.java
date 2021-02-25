package com.efurture.delaynotification.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;
import android.view.View;

import com.efurture.notication.manager.NotificationHelper;
import com.efurture.notication.manager.UploadWorker;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        findViewById(R.id.send_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkRequest uploadWorkRequest = new OneTimeWorkRequest.Builder(UploadWorker.class).setInitialDelay(10000, TimeUnit.MILLISECONDS).build();
                WorkManager.getInstance(getApplication()).enqueue(uploadWorkRequest);


            }
        });



    }
}