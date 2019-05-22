package com.mycompany.myapp;

import android.app.*;
import android.os.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(setResource("main" , "layout"));
    }

	private int setResource(String p0, String p1)
	{
		// TODO: Implement this method
		return getBaseContext().
		getResources().getIdentifier(p0, p1, getBaseContext().
		getPackageName());
	}
}
