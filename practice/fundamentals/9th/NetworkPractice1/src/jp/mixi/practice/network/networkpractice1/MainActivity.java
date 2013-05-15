package jp.mixi.practice.network.networkpractice1;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements LoaderCallbacks<String> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View buttonGet = findViewById(R.id.buttonGet);
        buttonGet.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                LoaderManager manager = getSupportLoaderManager();
                Bundle argsForLoader = new Bundle();
                manager.initLoader(0, argsForLoader, MainActivity.this);
            }
        });
        View buttonPost = findViewById(R.id.buttonPost);
        buttonPost.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                LoaderManager manager = getSupportLoaderManager();
                Bundle argsForLoader = new Bundle();
                manager.initLoader(1, argsForLoader, MainActivity.this);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public Loader<String> onCreateLoader(int arg0, Bundle arg1) {
    	TextView accessUrl = (TextView) findViewById(R.id.accessUrl);
   	 	TextView httpBody = (TextView) findViewById(R.id.httpBody);
        switch (arg0) {
        case 0:
            return new GetTaskLoader(this, accessUrl.getText().toString());
        case 1:
            return new PostTaskLoader(this, accessUrl.getText().toString(), httpBody.getText().toString());
        default:
            return null;
        }
	}

	@Override
	public void onLoadFinished(Loader<String> arg0, String arg1) {
        TextView responce = (TextView) findViewById(R.id.responce);
        responce.setText(arg1);
	}

	@Override
	public void onLoaderReset(Loader<String> arg0) {		
	}

}
