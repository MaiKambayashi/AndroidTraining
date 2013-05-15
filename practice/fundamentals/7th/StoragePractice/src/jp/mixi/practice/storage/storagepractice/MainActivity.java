package jp.mixi.practice.storage.storagepractice;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        Button internalFileSave = (Button) findViewById(R.id.internalFileSave);

        internalFileSave.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileOutputStream fos=openFileOutput("sample_text.txt", MODE_PRIVATE);
                    TextView text = (TextView) findViewById(R.id.text);
                    fos.write(text.getText().toString().getBytes());
                    fos.close();
                }catch(IOException e){
                	Log.e("Error", "" + e.toString());
                }                  
                try{
                    FileInputStream fis=openFileInput("sample_text.txt");
                    fis.read();
                    byte buffer[]=new byte[100];
                    fis.read(buffer);
                    Log.v("message", new String(buffer).trim());
                    fis.close();
                }catch(IOException e){
                	Log.e("Error", "" + e.toString());
                }                  
                Toast.makeText(MainActivity.this, "保存しました", Toast.LENGTH_LONG).show();
            }
        });

        
        Button externalFileSave = (Button) findViewById(R.id.externalFileSave);
        
        externalFileSave.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	try {            		
            		Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
            		Log.v("message", mBitmap.toString());
            		ByteArrayOutputStream output = new ByteArrayOutputStream();
            		mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, output);
            		byte[] imgData = output.toByteArray();
            		
            		File f = Environment.getExternalStorageDirectory();
                    String saveDir = f.getPath();
                    
            		TextView file = (TextView) findViewById(R.id.file);
            		Log.v("message",String.valueOf(file.getText()));
            		FileOutputStream fileOutputStream = null;
                    fileOutputStream = new FileOutputStream(saveDir + "/" + file.getText().toString() + ".jpg");
                    fileOutputStream.write(imgData);            		
                    fileOutputStream.close();
            	} catch (IOException e) {
            		Log.e("Error", "" + e.toString());
            	}
                Toast.makeText(MainActivity.this, "保存しました", Toast.LENGTH_LONG).show();
            }
        });

    }

	protected String getExternalFilesDir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
