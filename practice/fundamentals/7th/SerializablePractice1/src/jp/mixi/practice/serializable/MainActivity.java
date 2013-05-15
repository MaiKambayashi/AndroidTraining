package jp.mixi.practice.serializable;

import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1. 取得したデータをUserクラスにマッピングしてください。
        // 2. UserクラスにParcelableインターフェイスを実装してください。
        // 各項目を画面に表示してください
        NetworkClient client = new NetworkClient();
        String user = client.getUser(123);
        User userClass = new User();
        User.Status statusClass = new User.Status();
        try {
			JSONObject json = new JSONObject(user);
	        JSONObject statusObj = json.getJSONObject("status");
	        statusClass.setText(statusObj.optString("text"));

	        userClass.setId(json.optInt("id"));
	        userClass.setName(json.optString("name"));
	        userClass.setAge(json.optInt("age"));
	        userClass.setKeyword(json.optString("keyword"));	        
	        userClass.setStatus(statusClass);
		} catch (JSONException e) {
			e.printStackTrace();
		}
        Intent intent = new Intent();
        intent.putExtra("userClass", userClass);
        User userData = intent.getParcelableExtra("userClass");

        TextView userId = (TextView)findViewById(R.id.userId);
        TextView userName = (TextView)findViewById(R.id.userName);
        TextView userAge = (TextView)findViewById(R.id.userAge);
        TextView userKeyword = (TextView)findViewById(R.id.userKeyword);
        TextView userStatusText = (TextView)findViewById(R.id.userStatusText);

        userId.setText(String.valueOf(userData.getId()));
        userName.setText(String.valueOf(userData.getName()));
        userAge.setText(String.valueOf(userData.getAge()));
        userKeyword.setText(String.valueOf(userData.getKeyword()));
        userStatusText.setText(String.valueOf(userData.getStatus().getText()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

