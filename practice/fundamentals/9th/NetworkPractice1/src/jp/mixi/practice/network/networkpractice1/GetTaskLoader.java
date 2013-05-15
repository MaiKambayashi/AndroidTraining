package jp.mixi.practice.network.networkpractice1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class GetTaskLoader extends AsyncTaskLoader<String> {
	String  mAccessUrl;
	public GetTaskLoader(Context context, String accessUrl) {
        super(context);
        mAccessUrl = accessUrl;
    }

    @Override
    public String loadInBackground() {
        HttpURLConnection connection = null;
        StringBuilder src = new StringBuilder();
        try {        	
        	URL url = new URL(mAccessUrl);
        	connection = (HttpURLConnection) url.openConnection();
        	connection.connect();
        	InputStream is = connection.getInputStream();
        	while (true) {
        		byte[] line = new byte[1024];
        		int size = is.read(line);
        		if (size <= 0)
        			break;
             	src.append(new String(line, "euc-jp"));
        	}             
     	} catch (IOException e) {
     		e.printStackTrace();
     	} finally{
     		connection.disconnect();
     	}
        return src.toString();
    }
    
    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}