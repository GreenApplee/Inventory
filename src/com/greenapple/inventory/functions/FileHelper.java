package com.greenapple.inventory.functions;

import java.io.File;

import com.greenapple.inventory.model.Product;

public class FileHelper {
	
	
	/********** Method for creating a file in the internal memory*******/
	
	public File createFile(String path, String fileName){
		File root= new File(path);
		if(!root.exists()){
			//create a new file
			root.mkdirs();
		}
		File f=new File(root,fileName);
		return f;	
	}
	
	public Boolean deleteFile(String path){
		File f= new File(path);
		return f.delete();
	}
	
	public void addProduct(Product product){
		
	}
	
	
	
	public void exportToCSV(String path, String fileName){
	  //create the xls file in external storage
		
	  //get the list of all products withing this file
	
	  //add the products in the file
	}
	
	public void exportToPDF(String path, String fileName){
	  //create the xls file in external storage
		
	 //get the list of all products withing this file
		
	 //add the products in the file
	}

}
