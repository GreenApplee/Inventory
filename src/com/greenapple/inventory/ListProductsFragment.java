package com.greenapple.inventory;

import com.greenapple.inventory.R;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListProductsFragment extends Fragment {
	
	public ListProductsFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_list_products, container, false);
         
        return rootView;
    }
}
