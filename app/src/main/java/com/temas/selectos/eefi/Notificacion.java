package com.temas.selectos.eefi;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Notificacion extends Application {
    public static final String Canal_1_ID = "canal1";
    public static final String Canal_2_ID = "canal2";

    @Override
    public void onCreate() {
        super.onCreate();

        creaCanalDeNotificaciones();
    }

    private void creaCanalDeNotificaciones(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel canal1 = new NotificationChannel(Canal_1_ID, "Canal 1", NotificationManager.IMPORTANCE_HIGH);
            canal1.setDescription("Este es el canal 1");

            NotificationChannel canal2 = new NotificationChannel(Canal_2_ID, "Canal 2", NotificationManager.IMPORTANCE_LOW);
            canal2.setDescription("Este es el canal 2");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(canal1);
            manager.createNotificationChannel(canal2);
        }
    }
}
