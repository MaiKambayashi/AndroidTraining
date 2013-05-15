package jp.mixi.practice.network.networkpractice2;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class PostTaskLoader extends AsyncTaskLoader<String> {
	String  mAccessUrl;
	String mHttpBody;
	public PostTaskLoader(Context context, String accessUrl, String httpBody) {
        super(context);
        mAccessUrl = accessUrl;
        mHttpBody = httpBody;
    }

    @Override
    public String loadInBackground() {
    	HttpClient client = new DefaultHttpClient();
        String responce = null;
        URI url = null;
        try {        	
        	url = new URI(mAccessUrl); 
        } catch (URISyntaxException e) {
			e.printStackTrace();
		}
        try {        	
        	client.getParams().setParameter("body", mHttpBody);
        	responce = client.execute(new HttpPost(url),
                new ResponseHandler<String>() {
            		public String handleResponse(HttpResponse response)
                    throws ClientProtocolException, IOException {
            			return EntityUtils.toString(response.getEntity());
            		}
            	}
        	);
     	} catch (IOException e) {
     		e.printStackTrace();
     	}
        return responce;
    }
    
    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}