package com.example.myfirst;
import java.util.Random;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity implements View.OnClickListener{
	Button submit;
	ToggleButton tgbtn;
	EditText cmd;
	TextView display;
	// ImageView image;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
			
		setContentView(R.layout.text);
		 sock();
		tgbtn.setOnClickListener(this);
		
		submit.setOnClickListener(this);
	}

	

	private void sock() {
		// TODO Auto-generated method stub
		 submit = (Button) findViewById(R.id.cmdbtn);
	     tgbtn = (ToggleButton) findViewById(R.id.tgbtn);
	     cmd = (EditText) findViewById(R.id.etcmd);
	     display = (TextView) findViewById(R.id.txtresult);
		
	}

	@TargetApi(Build.VERSION_CODES.CUPCAKE)
	@SuppressLint("NewApi")
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		
		switch(arg0.getId()){
		case R.id.cmdbtn:
			String comand = cmd.getText().toString();
			
			if(comand.contentEquals("left"))
			{
				display.setGravity(Gravity.LEFT);
				}else if(comand.contentEquals("right")){
			display.setGravity(Gravity.RIGHT);
			}else if(comand.contentEquals("center")){
				display.setGravity(Gravity.CENTER);
				}else if(comand.contentEquals("blue")){
					display.setTextColor(Color.BLUE);
					display.setText("blue");
				}else if(comand.contentEquals("wtf")){
					display.setText("wtf!!!!");
					Random crazy = new Random();
					display.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265), crazy.nextInt(265)));
					display.setTextSize(crazy.nextInt(77));
					switch(crazy.nextInt(3)){
					case 0:
						display.setGravity(Gravity.LEFT);
						break;
					case 1:
						display.setGravity(Gravity.CENTER);
						break;
					case 2:
						display.setGravity(Gravity.RIGHT);
						break;
						
					}
				}
			
			else{
					display.setGravity(Gravity.CENTER);
					display.setText("invalid");
					display.setTextSize(20);
					display.setTextColor(Color.BLACK);
				}
			break;
			
		case R.id.tgbtn:
			if(tgbtn.isChecked()){
				cmd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD );
			}else{
				cmd.setInputType(InputType.TYPE_CLASS_TEXT);
				
			}
			break;
			
		}
		
	}

}
