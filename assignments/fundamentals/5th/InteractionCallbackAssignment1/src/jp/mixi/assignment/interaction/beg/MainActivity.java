
package jp.mixi.assignment.interaction.beg;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	private Menu private_menu;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
	public boolean onPrepareOptionsMenu(Menu menu){
		private_menu = menu;
        return true;
	}
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	if( item.getItemId() == R.id.action_refresh){
    		MenuItem settings = private_menu.findItem(R.id.action_settings);
    		if(settings.isEnabled() == true){
    			settings.setEnabled(false);
    		}else{
        		settings.setEnabled(true);    			
    		}
    	}
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
