package com.greenapple.inventory;

import com.greenapple.inventory.R;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NewProductFragment extends Fragment {
	
	public NewProductFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_new_product, container, false);
         
        return rootView;
    }
}
