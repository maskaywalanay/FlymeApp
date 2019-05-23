package com.mycompany.myapp;
import android.preference.*;
import android.content.*;
import android.util.*;
import android.text.*;

public class GreetEditText extends EditTextPreference
{
	public GreetEditText(Context c, AttributeSet attr, int inis)
	{
		super(c, attr, inis);
	}
	
	public GreetEditText(Context c, AttributeSet attr)
	{
		super(c, attr);
	}
	
	public GreetEditText(Context c)
	{
		super(c);
		
	}

	@Override
	public CharSequence getSummary()
	{
		// TODO: Implement this method
		String tulisan = getText();
		if(TextUtils.isEmpty(tulisan))
		{
			return getEditText().getHint();
		}
		else
		{
			CharSequence summary = super.getSummary();
			if(summary != null)
			{
				return String.format(summary.toString(),tulisan);
			}
			else
			{
				return null;
			}
		}
	}
}
