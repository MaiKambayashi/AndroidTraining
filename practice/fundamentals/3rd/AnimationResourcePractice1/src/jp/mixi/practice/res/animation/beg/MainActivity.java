
package jp.mixi.practice.res.animation.beg;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View textView1 = findViewById(R.id.TextView1);
        View textView2 = findViewById(R.id.TextView2);
        View textView3 = findViewById(R.id.TextView3);
        View textView4 = findViewById(R.id.TextView4);
        View textView5 = findViewById(R.id.TextView5);

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.sample_animation1);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.sample_animation2);
        Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.sample_animation3);
        
        textView1.startAnimation(animation3);
        textView2.startAnimation(animation1);
        textView3.startAnimation(animation2);
        textView4.startAnimation(animation2);
        textView5.startAnimation(animation3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
