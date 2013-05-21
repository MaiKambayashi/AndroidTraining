package jp.mixi.practice.test.target.test;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import jp.mixi.practice.test.target.TestTarget3;
import jp.mixi.practice.test.target.R;

public class ActivityInstrumentation extends
	ActivityInstrumentationTestCase2<TestTarget3>{
    public ActivityInstrumentation() {
        this(TestTarget3.class);
    }
    
	public ActivityInstrumentation(Class<TestTarget3> activityClass) {
		super(activityClass);
	}

    public void testEditTextScenario() throws Exception {
        Activity activity = getActivity();

        final TextView title = (TextView) activity.findViewById(R.id.TitleEditor);
        final TextView content = (TextView) activity.findViewById(R.id.ContentEditor);        

        // 初期値
        assertEquals("", title.getText().toString());
        assertEquals("", content.getText().toString());

        // title編集をシミュレート
        activity.runOnUiThread( new Runnable() {
            @Override
            public void run() {
            	title.setText("天気予報");
            	content.setText("晴れときどき曇り");
            }
        });
        
        // 待機する
        getInstrumentation().waitForIdleSync();
        
        assertEquals("天気予報", title.getText().toString());
        assertEquals("晴れときどき曇り", content.getText().toString());

        // 画面回転する
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Thread.sleep(1000L);

        // 引き継がれているはず
        assertEquals("天気予報", title.getText().toString());
        assertEquals("晴れときどき曇り", content.getText().toString());
    }
}
