package com.example.myfirst;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class camera extends Activity implements View.OnClickListener {
	
	ImageButton ib;
	ImageView iv;
	Button b;
	final static int camresul= 0;
	Intent i;
	Bitmap bmp;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		initializers();
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		bmp = BitmapFactory.decodeStream(is);
	}
	
	
	private void initializers() {
		// TODO Auto-generated method stub
		
		ib = (ImageButton) findViewById(R.id.imgbtn);
		iv = (ImageView) findViewById(R.id.imgviw);
		b = (Button) findViewById(R.id.btnset);
		ib.setOnClickListener(this);
		b.setOnClickListener(this);
	}
	
	
	


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
			case R.id.btnset :
			try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setContentView(R.layout.setwalldone);
			
			break;
			case R.id.imgbtn:
				i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(i, camresul);
			break;
		}
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK){
			Bundle extr = data.getExtras();
			bmp = (Bitmap) extr.get("data");
			iv.setImageBitmap(bmp);
		}
	}

}
