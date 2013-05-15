package jp.mixi.practice.sharedpreferences.sharedpreferencespractice1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private SharedPreferences mPrivatePreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                
        // privatePreferencesに値が存在すればその値を表示をしてください。        
        mPrivatePreferences = getSharedPreferences("person", MODE_PRIVATE);
        String mName = mPrivatePreferences.getString("name", (String) "no name");
        int mAge = mPrivatePreferences.getInt("age", (int) 0);
        boolean mHamster = mPrivatePreferences.getBoolean("hamster", (boolean) false);
        long mSunflower = mPrivatePreferences.getLong("long", (long) 100445);
        float mSeed = mPrivatePreferences.getFloat("seed", (float) 2.311356);
        
        TextView tName = (TextView) findViewById(R.id.userName);
        TextView tAge = (TextView) findViewById(R.id.userAge);
        TextView tHamster = (TextView) findViewById(R.id.userHamster);
        TextView tSunflower = (TextView) findViewById(R.id.userSunflower);
        TextView tSeed = (TextView) findViewById(R.id.userSeed);
                
    	tName.setText(mName);
    	tAge.setText(String.valueOf(mAge));
    	tHamster.setText(String.valueOf(mHamster));
    	tSunflower.setText(String.valueOf(mSunflower));
    	tSeed.setText(String.valueOf(mSeed));
        
        // privatePreferencesにString,int,boolean,long,floatで何らかの値を保存してください。
        final Editor editor = mPrivatePreferences.edit();
        editor.putString("name", "ハム太郎");
        editor.putInt("age", 3);
        editor.putBoolean("hamster", true);
        editor.putLong("sunflower", 1234567890);
        editor.putFloat("seed", (float) 1.459872);
        boolean saveResult = editor.commit();
        String popup = saveResult ? "保存しました" : "保存できませんでした";
    	Toast.makeText(this, popup, Toast.LENGTH_LONG).show();
        
        Button clearButton = (Button) findViewById(R.id.clear);
        clearButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // 内容をクリアする処理を書いてください。
            	editor.clear();
            	boolean clearResult = editor.commit();
                String popup = clearResult ? "削除しました" : "削除できませんでした";
            	Toast.makeText(MainActivity.this, popup, Toast.LENGTH_LONG).show();
            }
        });

    }
        
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
