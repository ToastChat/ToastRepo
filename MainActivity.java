package com.mycompany.toastchat;

import android.app.*;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CheckBox;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.view.View.*;
import android.widget.Toast;
import android.view.MenuItem.OnMenuItemClickListener;
import android.content.*;
import android.view.Menu;
import android.view.MenuItem;
import android.graphics.drawable.*;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.*;

public class MainActivity extends Activity 
{
	DbHelper helper = new DbHelper(this);
	EditText username, paswd, conpaswd;
	Button btn, btn2;
	CheckBox chkbox;
	String name, pas, conpas;
		ImageButton ImgBtn;
		RadioGroup radiosex;
		RadioButton radiosexbtn, radiom, radiof;
	final Context Context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
		username = (EditText) findViewById(R.id.t1);
		paswd = (EditText) findViewById(R.id.t2);
		btn = (Button) findViewById(R.id.b1);
		btn = (Button) findViewById(R.id.b2);
		chkbox = (CheckBox) findViewById(R.id.c1);
		conpaswd = (EditText) findViewById(R.id.t3);
		ImgBtn = (ImageButton) findViewById(R.id.im);
				chkbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton button, boolean Checked) {
					
					if (!Checked) {
                        
						paswd.setTransformationMethod(PasswordTransformationMethod.getInstance());
						conpaswd.setTransformationMethod(PasswordTransformationMethod.getInstance());
					} else {
                    
						paswd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
						conpaswd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
					}
				}
			});
	}
	
	public void buttonClick(View v){
		pas = paswd.getText().toString();
		name= username.getText().toString();
		conpas = conpaswd.getText().toString();
		if(!pas.equals(conpas)){
			Toast.makeText(this, "Password Does not Tally", Toast.LENGTH_SHORT).show();
			
			}
		else if(name.equals("")){
			Toast.makeText(this, "Provide Username", Toast.LENGTH_SHORT).show();
	}
		else if (pas.equals("") && conpas.equals("")){

			Toast.makeText(this, "Provide Password Nigga", Toast.LENGTH_SHORT).show();
		}
		else if (pas.equals("") || conpas.equals("")){
			Toast.makeText(this, "Either Of The Password Field Is Empty", Toast.LENGTH_SHORT).show();
		}
		else{
			AlertDialog.Builder alert = new AlertDialog.Builder(Context);

			alert.setTitle("Validating...")
			.setIcon(R.drawable.image);
			alert.setMessage("Sure To Continue As "+name +"?")
				.setCancelable(false)
				.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int id){
						Contacts c = new Contacts();
						c.setNam(name);
						c.setPass(pas);
					helper.insertDetails(c);
					}
				})
				.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int id){
						dialog.cancel();
					}
				});
			AlertDialog dialogue = alert.create();
			dialogue.show();
			
			}
		}
	
}
