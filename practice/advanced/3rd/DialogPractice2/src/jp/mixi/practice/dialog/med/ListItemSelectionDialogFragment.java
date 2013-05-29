package jp.mixi.practice.dialog.med;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * TODO: ダイアログで、はい・いいえ の選択肢を表示する
 * TODO: はい、を選択したら、リストの項目を削除する
 * @author keishin.yokomaku
 *
 */
public class ListItemSelectionDialogFragment extends DialogFragment {    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder
    		.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
    			public void onClick(DialogInterface dialog, int id) {
    			    ListView list = (ListView) getActivity().findViewById(R.id.ListView);
    			    String item = (String)list.getItemAtPosition(id);
    			    ArrayAdapter<String> adapter = (ArrayAdapter<String>)list.getAdapter();
    			    adapter.remove(item);
    			    list.setAdapter(adapter);
    			}
    		})
        	.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
        		public void onClick(DialogInterface dialog, int id) {
                }
        	});
        return builder.create();
    }
}
