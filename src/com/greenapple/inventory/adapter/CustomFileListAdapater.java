package com.greenapple.inventory.adapter;

import java.util.ArrayList;

import com.greenapple.inventory.AboutFragment;
import com.greenapple.inventory.EditFileFragment;
import com.greenapple.inventory.ExportFileFragment;
import com.greenapple.inventory.HomeFragment;
import com.greenapple.inventory.HowToFragment;
import com.greenapple.inventory.ListFilesFragment;
import com.greenapple.inventory.ListProductsFragment;
import com.greenapple.inventory.MainActivity;
import com.greenapple.inventory.NewFileFragment;
import com.greenapple.inventory.NewProductFragment;
import com.greenapple.inventory.R;
import com.greenapple.inventory.model.ListItem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CustomFileListAdapater extends BaseAdapter implements OnClickListener {

	 private ActionBarActivity activity;
     private ArrayList data;
     private static LayoutInflater inflater=null;
     public Resources res;
     ListItem tempValues=null;
     int i=0;
	 public CustomFileListAdapater(FragmentActivity fragmentActivity, ArrayList d,Resources resLocal) {
         
         /********** Take passed values **********/
          activity = (ActionBarActivity) fragmentActivity;
          data=d;
          res = resLocal;
       
          /***********  Layout inflator to call external xml layout () ***********/
           inflater = ( LayoutInflater )activity.
                                       getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       
	 }
	
	 
	   public int getCount() {
           
           if(data.size()<=0)
               return 1;
           return data.size();
       }
    
       public Object getItem(int position) {
           return position;
       }
    
       public long getItemId(int position) {
           return position;
       }
        
       /********* Create a holder Class to contain inflated xml file elements *********/
       public static class ViewHolder{
            
           public TextView fileOrproduct;
           public TextView numberOrfile;
           public Button edit;
           public Button delete;
           public int num;
    
       }
    
       /****** Depends upon data size called for each row , Create each ListView row *****/
       public View getView(final int position, View convertView, ViewGroup parent) {
            
           View vi = convertView;
           final ViewHolder holder;
            
           if(convertView==null){
                
               /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
               vi = inflater.inflate(R.layout.item_list_files, null);
                
               /****** View Holder Object to contain item_list_files.xml file elements ******/

               holder = new ViewHolder();
               holder.fileOrproduct = (TextView) vi.findViewById(R.id.textView1);
               holder.numberOrfile=(TextView)vi.findViewById(R.id.textView2);
               holder.edit=(Button)vi.findViewById(R.id.button1);
               holder.delete=(Button)vi.findViewById(R.id.button2);
              /************  Set holder with LayoutInflater ************/
               vi.setTag( holder );
               
             
           }
           else 
               holder=(ViewHolder)vi.getTag();
            
           if(data.size()<=0)
           {
               holder.fileOrproduct.setText("No Data");
                
           }
           else
           {
               /***** Get each Model object from Arraylist ********/
               tempValues=null;
               tempValues = ( ListItem ) data.get( position );
                
               /************  Set Model values in Holder elements ***********/

                holder.fileOrproduct.setText( tempValues.getProductOrfile() );
                holder.numberOrfile.setText( tempValues.getNumberOrfile() );
                holder.num=tempValues.getNum(); 
                /******** Set Item Click Listner for LayoutInflater for each row *******/

                vi.setOnClickListener(new OnItemClickListener( position ));
                
                /*********** Set onClickListeners to edit and delete buttons ****/
           
                holder.edit.setOnClickListener(new OnClickListener(){

    				@Override
    				public void onClick(View arg0) {
    					// TODO Auto-generated method stub
    					
    					//open fragment createFile and send name and description and boolean
    					Fragment fragment = null;
    					fragment = new EditFileFragment();
    					final Bundle bundle = new Bundle();
    					bundle.putInt("Num", holder.num);
    					 bundle.putString("Name", String.valueOf(holder.fileOrproduct.getText()));
    					 bundle.putString("Desc", String.valueOf(holder.numberOrfile.getText()));
    					 fragment.setArguments(bundle); 
    					FragmentManager fragmentManager = activity.getSupportFragmentManager();
    					fragmentManager.beginTransaction()
    							.replace(R.id.frame_container, fragment).commit();
    				}
                	  
                  });
                  
                  holder.delete.setOnClickListener(new OnClickListener(){

    				@Override
    				public void onClick(View v) {
    					// TODO Auto-generated method stub
    					
    					//get file from database
    					
    					//check if there is a path
    					
    					//if path exists show alert dialog to wether or not delete the file in the filesystem
    					
    					//if answer yes delete file from database and filesystem
    					
    					//else delete file from database
    				}
                	  
                  });
           }
           return vi;
       }
        
       @Override
       public void onClick(View v) {
               Log.v("CustomAdapter", "=====Row button clicked=====");
       }
        
       /********* Called when Item click in ListView ************/
       private class OnItemClickListener  implements OnClickListener{          
           private int mPosition;
            
           OnItemClickListener(int position){
                mPosition = position;
           }
            
           @Override
           public void onClick(View arg0) {

      
             //CustomListViewAndroidExample sct = (CustomListViewAndroidExample)activity;

            /****  Call  onItemClick Method inside CustomListViewAndroidExample Class ( See Below )****/

               //sct.onItemClick(mPosition);
           }              
       } 
       
       

}
