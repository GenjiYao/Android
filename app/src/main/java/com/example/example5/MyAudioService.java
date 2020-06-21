package com.example.example5;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyAudioService extends Service {
    MediaPlayer mp ;
    public MyAudioService() {

    }
    @Override
    public void onCreate()
    {
        super.onCreate();
        mp = MediaPlayer.create(getApplicationContext(),R.raw.firedance);
        mp.start();
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        mp.stop();
        if (mp != null)
            mp=null;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
