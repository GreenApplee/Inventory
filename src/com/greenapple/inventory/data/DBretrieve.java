package com.greenapple.inventory.data;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.greenapple.inventory.model.*;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class DBretrieve {

	private SQLiteDatabase db;
	private DBhelper dbhelper;
	Context mycontext;
	public DBretrieve(Context context)
	{
		this.dbhelper= new DBhelper(context);
		mycontext=context;
	}
	
	public void open() throws SQLException {
		db = dbhelper.getWritableDatabase();
	}

	public void close() {
		dbhelper.close();
	}
	public void remove(){
		mycontext.deleteDatabase("InventoryDB");
	}
	
	/*************** INSERT METHODS *******************/
	public void insert_file(File file){
			
			ContentValues values = new ContentValues();
			values.put(DBhelper.col_name, file.getNom());
			values.put(DBhelper.col_desc, file.getDesc());
			values.put(DBhelper.col_path, file.getPath());
			db.insert(DBhelper.table_file, null, values);
			
		}
	
	public void insert_product(Product product){
		
		ContentValues values = new ContentValues();
		values.put(DBhelper.col_code1, product.getCode1());
		values.put(DBhelper.col_code2, product.getCode2());
		values.put(DBhelper.col_designation, product.getDesignation());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		values.put(DBhelper.col_dateAcq, dateFormat.format(product.getDateAcq()));
		values.put(DBhelper.col_dateAj, dateFormat.format(product.getDateAj()));
		values.put(DBhelper.col_etat, product.getEtat());
		values.put(DBhelper.col_prix, product.getPrix());
		values.put(DBhelper.col_facture, product.getFacture());
		values.put(DBhelper.col_num_file, product.getNum_file());
		db.insert(DBhelper.table_file, null, values);
		
	}
	
	/************ UPDATE METHODS*********************/
	public void EditFile(int num, String nom, String desc){
		ContentValues values = new ContentValues();
		values.put(DBhelper.col_name, nom);
		values.put(DBhelper.col_desc, desc);
		db.update(DBhelper.table_file, values, "num = "+num,null);
	}
	
	/************* GET METHODS *******************/
	public ArrayList<File> get_Files(){
		ArrayList<File> result= new ArrayList<File>();
		String getFiles="select * from file ";
		Cursor cursor= db.rawQuery(getFiles, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
		 File file= CursorToFile(cursor);
		 result.add(file);
		 cursor.moveToNext();
		}
		cursor.close();
		return result;
	}
	
	public List<Product> get_Products(){
		List<Product> result= new ArrayList<Product>();
		String getProducts="select * from product ";
		Cursor cursor= db.rawQuery(getProducts, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
		 Product product= CursorToProduct(cursor);
		 result.add(product);
		 cursor.moveToNext();
		}
		cursor.close();
		return result;
		
	}
	
	/************** DEFINING CURSORS *********************/
	private File CursorToFile(Cursor cursor){
		File file= new File();
		file.setNum(cursor.getInt(0));
		file.setNom(cursor.getString(1));
		file.setDesc(cursor.getString(2));
		file.setPath(cursor.getString(3));
		return file;
	}
	
	private Product CursorToProduct(Cursor cursor){
		Product product= new Product();
		product.setNum(cursor.getInt(0));
		product.setCode1(cursor.getString(1));
		product.setCode2(cursor.getString(2));
		product.setDesignation(cursor.getString(3));
		String s= cursor.getString(4);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=new Date();
		try {
			 d=  dateFormat.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		product.setDateAcq(d);
		s=cursor.getString(5);
		d=new Date();
		try {
			 d=  dateFormat.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		product.setDateAj(d);
		product.setEtat(cursor.getString(6));
		product.setPrix(cursor.getFloat(7));
		product.setFacture(cursor.getString(8));
		product.setNum_file(cursor.getInt(9));
		return product;
	}
	
}
