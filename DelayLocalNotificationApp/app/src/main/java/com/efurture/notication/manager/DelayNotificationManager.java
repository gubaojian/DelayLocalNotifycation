package com.efurture.notication.manager;

public class DelayNotificationManager {

    private static DelayNotificationManager mDelayNotificationManager;

    /**
     * 发送DelayManager
     * */
    public static DelayNotificationManager getInstance(){
        if(mDelayNotificationManager == null) {
            synchronized (DelayNotificationManager.class) {
                if (mDelayNotificationManager == null) {
                    mDelayNotificationManager = new DelayNotificationManager();
                }
            }
        }
        return mDelayNotificationManager;
    }

}
