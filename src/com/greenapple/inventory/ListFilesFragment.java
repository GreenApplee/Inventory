package com.greenapple.inventory;

import java.util.ArrayList;
import java.util.List;

import com.greenapple.inventory.R;
import com.greenapple.inventory.adapter.CustomFileListAdapater;
import com.greenapple.inventory.data.DBretrieve;
import com.greenapple.inventory.model.File;
import com.greenapple.inventory.model.ListItem;

import android.support.v4.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ListFilesFragment extends Fragment {
	
	public ListFilesFragment(){}
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_list_files, container, false);
         
        return rootView;
    }


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		//construct an arraylist of files by getting list files from database
		DBretrieve db= new DBretrieve(getActivity().getApplicationContext());
		db.open();
		ArrayList<File> listfiles= new ArrayList<File>();
		listfiles=db.get_Files();
		ArrayList<ListItem> arraylist= new ArrayList<ListItem>();
		for(int i=0;i<listfiles.size();i++){
			File file=listfiles.get(i);
			ListItem item= new ListItem();
			item.setProductOrfile(file.getNom());
			item.setNumberOrfile(file.getDesc());
			item.setNum(file.getNum());
			arraylist.add(item);
		}
		//find the listview defined in the xml layout
		ListView list= (ListView)getActivity().findViewById(R.id.listView1);
		//set the adapter for the list_view
		 Resources res =getResources();
		CustomFileListAdapater adapter=new CustomFileListAdapater( getActivity(), arraylist,res );
        list.setAdapter( adapter );
	}
	
	
}
