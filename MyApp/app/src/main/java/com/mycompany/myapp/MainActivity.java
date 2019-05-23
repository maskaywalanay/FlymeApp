package com.mycompany.myapp;

import android.os.*;
import android.preference.*;

public class MainActivity extends PreferenceActivity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(setResource("pref" , "xml"));
    }

	private int setResource(String p0, String p1)
	{
		// TODO: Implement this method
		return getBaseContext().
		getResources().getIdentifier(p0, p1, getBaseContext().
		getPackageName());
	}
}
