
package jp.mixi.assignment.notification.beg;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO ここで通知を表示する
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification = builder
                // 通知のタイトル
                .setContentTitle("ハム太郎速報☆彡")
                // 通知の詳細メッセージ
                .setContentText("ハム太郎王国ひまわりの種祭")
                // 通知のアイコン
                .setSmallIcon(R.drawable.ic_launcher)
                // 通知をタップした時に使う PendingIntent
                .setContentIntent(pendingIntent)
                // タップしたら消えるようにする
                .setAutoCancel(true)
                .build();
        notification.vibrate = new long[]{0, 200, 100, 200, 100, 200};
        notification.tickerText = "新しいお知らせがあります";
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, notification);
    }
}