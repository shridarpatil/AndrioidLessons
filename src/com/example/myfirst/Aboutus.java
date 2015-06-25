package com.example.myfirst;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Aboutus extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.abtus);
		TextView abt = (TextView) findViewById(R.id.txtabtus);
	}
	
}
