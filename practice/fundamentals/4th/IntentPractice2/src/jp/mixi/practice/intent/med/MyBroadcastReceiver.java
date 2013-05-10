package jp.mixi.practice.intent.med;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {
	public static final String TAG = MyBroadcastReceiver.class.getSimpleName();
	
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v(TAG, intent.getStringExtra("action_name"));
    }
	
}