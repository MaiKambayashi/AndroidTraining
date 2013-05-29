package jp.mixi.training.inapppurchase;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import jp.mixi.training.inapppurchase.helper.DummySku;
import com.android.vending.billing.IInAppBillingService;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	private static final String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    bindService(new 
	            Intent("com.android.vending.billing.InAppBillingService.BIND"),
	                    mServiceConn, Context.BIND_AUTO_CREATE);
	}

	private void disableActionViews () {
		findViewById(R.id.action_start_accepted_purchase).setEnabled(false);
		findViewById(R.id.action_start_canceled_purchase).setEnabled(false);
	}
	private void enableActionViews () {
		findViewById(R.id.action_start_accepted_purchase).setEnabled(true);
		findViewById(R.id.action_start_canceled_purchase).setEnabled(true);
	}
	private void showResult (final boolean resultOk, final String text) {
		final TextView resultView = (TextView)findViewById(R.id.print_purchase_result);
		if (resultView != null) {
			resultView.setBackgroundColor(getResources().getColor(resultOk ? R.color.result_ok_bg : R.color.result_ko_bg));
			resultView.setText(text != null ? text : "good choice!!");
		} else {
			Log.w(TAG, "Can't find result view ; nothing done");
		}
	}


	@Override
	public void onDestroy() {
		super.onDestroy();
	    if (mServiceConn != null) {
	        unbindService(mServiceConn);
	    }
	}

	private void startPurchase (final DummySku skuToPurchase) {
		//IMP here
		ArrayList<String> skuList = new ArrayList<String>();
		skuList.add("premiumUpgrade");
		skuList.add("gas");
		Bundle querySkus = new Bundle();
		querySkus.putStringArrayList("ITEM_ID_LIST", skuList);
		String mPremiumUpgradePrice = null;
		String mGasPrice = null;
		try {
			Bundle skuDetails = mService.getSkuDetails(3, getPackageName(), "inapp", querySkus);
			int response = skuDetails.getInt("RESPONSE_CODE");
			Log.w(TAG, String.valueOf(response));
			if (response == 0) {
			   ArrayList <String> responseList = skuDetails.getStringArrayList("DETAILS_LIST");
			   for (String thisResponse : responseList) {
		   		JSONObject object;
				try {
					Log.w(TAG, "pass!");
					object = new JSONObject(thisResponse);
					String sku = object.getString("productId");
					String price = object.getString("price");
				      if (sku.equals("premiumUpgrade")) mPremiumUpgradePrice = price;
				      else if (sku.equals("gas")) mGasPrice = price;
						Log.w(TAG, mPremiumUpgradePrice);
						Log.w(TAG, mGasPrice);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void onStartAcceptedPurchaseClick (final View view) {
		startPurchase(DummySku.PURCHASED);
	}

	public void onStartCanceledPurchaseClick (final View view) {
		startPurchase(DummySku.CANCELED);
	}

	IInAppBillingService mService;

	ServiceConnection mServiceConn = new ServiceConnection() {
	   @Override
	   public void onServiceDisconnected(ComponentName name) {
	       mService = null;
	   }

	   @Override
	   public void onServiceConnected(ComponentName name, 
	      IBinder service) {
	       mService = IInAppBillingService.Stub.asInterface(service);
	   }
	};

}
