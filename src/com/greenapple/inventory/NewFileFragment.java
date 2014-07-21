package com.greenapple.inventory;

import com.greenapple.inventory.data.DBretrieve;
import com.greenapple.inventory.model.File;
import com.greenapple.inventory.R;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewFileFragment extends Fragment {
	
	public NewFileFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
        View rootView = inflater.inflate(R.layout.fragment_new_file, container, false);        
        return rootView;
        
    }

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		final File file= new File();
		final EditText name=(EditText)getActivity().findViewById(R.id.editText1);
		final EditText desc=(EditText)getActivity().findViewById(R.id.editText2);
		Button save=(Button)getActivity().findViewById(R.id.button1);
		
		
		save.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				file.setNom(name.getText().toString());
				file.setDesc(desc.getText().toString());
				DBretrieve db= new DBretrieve(getActivity());
				db.open();
				db.insert_file(file);
				db.close();

			}
			
		});
		
	}
	
}
