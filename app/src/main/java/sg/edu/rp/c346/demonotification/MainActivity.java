package sg.edu.rp.c346.demonotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int requestCode = 123;
    int notifcationID = 888;
    Button btnNotify1, btnNotify2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotify1 = findViewById(R.id.btnNotify1);
        btnNotify2 = findViewById(R.id.btnNotify2);

        btnNotify1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                // This channel only exist in Oreo Build.VERSION_CODES.O
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel("default", "Default Channel", NotificationManager.IMPORTANCE_DEFAULT);

                    channel.setDescription("This is for default notification");
                    notificationManager.createNotificationChannel(channel);


                }
                // This activity will be launched when the notification is clicked on
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, requestCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                // Build notifcation
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "default");
                builder.setContentTitle("Amazing Offer!");
                builder.setContentText("Subject");
                builder.setSmallIcon(android.R.drawable.btn_star_big_off);
                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);

                Notification n = builder.build();

                // An integer good to have, for you to programmtically cancel it
                notificationManager.notify(notifcationID, n);
                finish();
            }
        });

        btnNotify2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                // This channel only exist in Oreo Build.VERSION_CODES.O
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel("default", "Default Channel", NotificationManager.IMPORTANCE_DEFAULT);

                    channel.setDescription("This is for default notification");
                    notificationManager.createNotificationChannel(channel);


                }
                // This activity will be launched when the notification is clicked on
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, requestCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                // Notification with big text
                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
                bigText.setBigContentTitle("Big Text - Long Content");
                bigText.bigText("This is one big test " + "- A quick brown fox jumps over a lazy brown dog " + "\nLorem ipsum dolor sit amet, sea eu quod des");
                bigText.setSummaryText("Reflection Journal?");

                // Build notifcation
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "default");
                builder.setContentTitle("Amazing Offer!");
                builder.setContentText("Subject");
                builder.setSmallIcon(android.R.drawable.btn_star_big_off);
                builder.setContentIntent(pendingIntent);
                builder.setStyle(bigText);
                builder.setAutoCancel(true);

                Notification n = builder.build();

                // An integer good to have, for you to programmtically cancel it
                notificationManager.notify(notifcationID, n);
                finish();
            }
        });
    }
}
