package com.example.myfirst;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String Classes[] = {"MainActivity" , "TextPlay","Email","camera"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1 , Classes));
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		String cheese = Classes[position];
		try{
			Class ourClass = Class.forName("com.example.myfirst." + cheese);
			Intent ourIntent = new Intent(Menu.this, ourClass);
			startActivity(ourIntent);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}


	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
	super.onCreateOptionsMenu(menu);
		
		MenuInflater bas = getMenuInflater();
		bas.inflate(R.menu.cool_menu, menu);
		
		return true ;
	}

	
	
	public boolean onottionsselected(MenuItem item){
		
		switch(item.getItemId()){
		
		case R.id.abtus:
			Intent i = new Intent("com.example.myfirst.Aboutus");
			startActivity(i);
			break;
		case R.id.prefer:
			
			break;
		
		}
		return false;
		
	}

}
