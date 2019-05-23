package com.mycompany.myapp;
import android.widget.*;
import android.content.*;
import android.util.*;
import android.os.*;
import java.util.*;
import android.preference.*;

public class GreetingTexts extends TextView
{
	
	private Handler mHandler;
	private Runnable mRun;
	private Calendar cal;
	private int jam;
	private String Textpagi, Textsiang, Textsore, Textmalam;
	
	public GreetingTexts(final Context c, AttributeSet attr)
	{
		super(c, attr);
		
		mHandler = new Handler();
		mRun = new Runnable()
		{
			public void run()
			{
				SharedPreferences mSh = PreferenceManager.getDefaultSharedPreferences(c);
				Textpagi = mSh.getString("pagi" , "selamat pagi");
				Textsiang = mSh.getString("siang" , "selamat siang");
				Textsore = mSh.getString("sore" , "Selamat sore");
				Textmalam = mSh.getString("malam", "Selamat malam");
				float ukuran = Float.parseFloat(mSh.getString("ukuran" ,"14"));
				cal = Calendar.getInstance();
				jam =  cal.get(Calendar.HOUR_OF_DAY);
				
				if(jam > 5)
				{
					setText(Textpagi);
					setTextSize(ukuran);
				}
				
				if(jam < 14 && jam > 9)
				{
					setText(Textsiang);
					setTextSize(ukuran);
				}
				
				if(jam < 20 && jam > 13)
				{
					setText(Textsore);
					setTextSize(ukuran);
				}
				
				if(jam > 18)
				{
					setText(Textmalam);
					setTextSize(ukuran);
				}
				invalidate();
				long siki = SystemClock.uptimeMillis();
				long mengko = siki + (1000 - siki % 1000);
				mHandler.postAtTime(mRun,mengko);
			}
		};
		
		mRun.run();
		
	}
	
}
