
package jp.mixi.assignment.interaction.med;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

   private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void afterTextChanged(Editable s) {
        	TextView count = (TextView) findViewById(R.id.Count);
        	count.setText(String.valueOf( s.length() ));
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        TextView editText = (TextView) findViewById(R.id.EditText);
        editText.addTextChangedListener(mTextWatcher);
    }

    @Override
    protected void onStop() {
        TextView editText = (TextView) findViewById(R.id.EditText);
        editText.removeTextChangedListener(mTextWatcher);
        super.onStop();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
