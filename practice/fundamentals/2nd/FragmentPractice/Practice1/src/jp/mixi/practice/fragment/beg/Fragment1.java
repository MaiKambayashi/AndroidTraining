
package jp.mixi.practice.fragment.beg;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {
	public Fragment1(){}
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // LayoutInflater �𗘗p���āA���C�A�E�g�����\�[�X�Ƃ��ēǂݍ���
        View view = inflater.inflate(R.layout.fragment1, container, false);
        return view;
    }
}