
package jp.mixi.assignment.controller.adv;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentTitle extends Fragment {

	@Override
	public View onCreateView(
		LayoutInflater inflater, 
		ViewGroup container, 
		Bundle savedInstanceState) {
		return inflater.inflate(R.layout.flagment_title, container, false);
	}

}
