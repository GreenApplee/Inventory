package com.greenapple.inventory.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

	

	static final String dbName="InventoryDB";
	
	static final String table_file= "file";
	static final String table_product= "product";
	
	//columns table_file
	static final String col_num= "num";
	static final String col_name= "name";
	static final String col_desc= "desc";
	static final String col_path= "path";
	//columns table_product
	static final String col_code1= "code1";
	static final String col_code2= "code2";
	static final String col_designation= "designation";
	static final String col_dateAcq="dateAcq";
	static final String col_dateAj="dateAj";
	static final String col_etat= "etat";
	static final String col_prix= "prix";
	static final String col_facture= "facture";
	static final String col_num_file= "num_file";
	
	
	
Context MyContext;
	
	public DBhelper(Context context)
	{
		
		super(context,dbName ,null,1);
		MyContext=context;
		
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE "+table_file+"("+col_num+" INTEGER PRIMARY KEY, "+ col_name+" TEXT, "+col_desc+" TEXT, "+col_path+" TEXT );");
		db.execSQL("CREATE TABLE "+table_product+"("+col_num+" INTEGER PRIMARY KEY, "+ col_code1+" TEXT,"+col_code2+ " TEXT, "+col_designation+" TEXT, "
		+col_dateAcq+" DATETIME,"+col_dateAj+" DATETIME,"+col_etat+" TEXT,"+col_prix+" FLOAT,"+col_facture+" TEXT,"+col_num_file+" TEXT, FOREIGN KEY ( "+col_num_file+" ) REFERENCES "
				+table_file+" ( "+col_num+" ));");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + table_file + ";");
		db.execSQL("DROP TABLE IF EXISTS " + table_product + ";");
		onCreate(db);
	}

}
