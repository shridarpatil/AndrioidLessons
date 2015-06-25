package com.example.myfirst;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;


public class Email extends Activity implements OnClickListener{
	
	
	EditText personame, intro, hatefulintro, personemail,stupidthings,outro;
	String emailadd, name, beginninig, stupidtxt, hateaction,outr;
	Button Email ; 
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializers();
	Email.setOnClickListener(this);	
	}
	private void initializers() {
		// TODO Auto-generated method stub
		personemail = (EditText) findViewById(R.id.emtxt);
		intro = (EditText) findViewById(R.id.intro);
		personame = (EditText) findViewById(R.id.personname);
		stupidthings = (EditText) findViewById(R.id.stupidtxt);
		hatefulintro = (EditText) findViewById(R.id.hatefultxt);
		outro = (EditText) findViewById(R.id.outro);
		Email = (Button) findViewById(R.id.embtn);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		convertEditTextvarsIntoString();
		String emailaddress[] = {emailadd };
		String msg = "hello world" + name + "i just wanted to say hii" + beginninig
				   + "i hate u"+ stupidtxt +"u r really crazy"+hateaction+"kjifdlewj"+ "iloveu";
		
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "i hate u");
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, msg);
		startActivity(emailIntent);
		
	}
	private void convertEditTextvarsIntoString() {
		// TODO Auto-generated method stub
		emailadd = personemail.getText().toString() ; name= personame.getText().toString();
		beginninig = intro.getText().toString();
		stupidtxt=stupidthings.getText().toString(); hateaction=hatefulintro.getText().toString();
	//	outr=outro.getText().toString();
		
	}
	protected void onPause(){
		super.onPause();
		 finish();
		 
	}
	
}
