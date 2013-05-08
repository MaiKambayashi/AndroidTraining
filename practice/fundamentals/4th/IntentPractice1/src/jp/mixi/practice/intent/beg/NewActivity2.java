package jp.mixi.practice.intent.beg;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Intent;

public class NewActivity2 extends Activity {
	public static final String EXTRA_MY_TEXT = "jp.mixi.practice.intent.beg.EXTRA_MY_TEXT";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent receivedIntent = getIntent();
        String extraText = receivedIntent.getStringExtra(EXTRA_MY_TEXT);
        Toast.makeText(this, extraText, Toast.LENGTH_LONG).show();
    }
}
