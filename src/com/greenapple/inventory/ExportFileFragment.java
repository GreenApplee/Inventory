package com.greenapple.inventory;

import com.greenapple.inventory.R;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ExportFileFragment extends Fragment {
	
	public ExportFileFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_export_file, container, false);
         
        return rootView;
    }
}
