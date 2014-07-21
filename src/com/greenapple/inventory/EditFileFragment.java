package com.greenapple.inventory;

import com.greenapple.inventory.data.DBretrieve;
import com.greenapple.inventory.model.File;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditFileFragment extends Fragment {
public EditFileFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
        View rootView = inflater.inflate(R.layout.fragment_new_file, container, false);        
        return rootView;
        
    }

	@SuppressLint("NewApi")
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		final File file= new File();
		final EditText name=(EditText)getActivity().findViewById(R.id.editText1);
		final EditText desc=(EditText)getActivity().findViewById(R.id.editText2);
		
		final int num = getArguments().getInt("Num", -1);
		final String nom= getArguments().getString("Name", "");
		final String descr= getArguments().getString("Desc", "");
		
		name.setText(nom);
		desc.setText(descr);
		Button save=(Button)getActivity().findViewById(R.id.button1);		
		save.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				//edit file in the database
				DBretrieve db= new DBretrieve(getActivity());
				db.open();
				db.EditFile(num, name.getText().toString(), desc.getText().toString());
				db.close();
				
				Toast.makeText(getActivity(), "Changements effectués", Toast.LENGTH_SHORT).show();
                
				
				//go to listFiles fragment
				Fragment fragment = null;
				fragment = new ListFilesFragment();
				FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
				fragmentManager.beginTransaction()
						.replace(R.id.frame_container, fragment).commit();
			}
			
		});
		
	}

}
